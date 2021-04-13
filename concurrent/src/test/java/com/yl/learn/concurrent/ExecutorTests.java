package com.yl.learn.concurrent;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorTests extends TestCase {
    
    public void testExecutor() {
        ExecutorService service = executorService();
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
    
        List<Future<Integer>> tasks = new ArrayList<>(num);
        for (int i = 0; i < 10; i++) {
            tasks.add(service.submit(new RandomRunnable(latch)));
        }
    
        try {
            latch.await();
            
            tasks.forEach(task -> {
                try {
                    System.out.println(task.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.isShutdown());
        service.shutdown();
        System.out.println(service.isShutdown());
    }
    
    class RandomRunnable implements Callable<Integer> {
        
        CountDownLatch latch;
        RandomRunnable(CountDownLatch latch) {
            this.latch = latch;
        }
    
        @Override
        public Integer call() throws Exception {
            int rs = (int) (Math.random() * 100);
            latch.countDown();
            return rs;
        }
    }
    
    private ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }
    
    public void test() {
        int COUNT_BITS = Integer.SIZE - 3;
    
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;
    
        PrintUtil.println(toS(RUNNING));
        PrintUtil.println(toS(SHUTDOWN));
        PrintUtil.println(toS(STOP));
        PrintUtil.println(toS(TIDYING));
        PrintUtil.println(toS(TERMINATED));
    
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        PrintUtil.println(toS(CAPACITY));
        PrintUtil.println(toS(~CAPACITY));
        PrintUtil.println(toS(RUNNING | 10));
    }
    
    private String toS(int num) {
        char[] rs = new char[32];
        int i = 0;
        while (i < rs.length) rs[i++] = '0';
        i--;
        
        while (num != 0) {
            rs[i--] = (num & 1) == 1 ? '1' : '0';
            num = num >>> 1;
        }
        return new String(rs);
    }
}
