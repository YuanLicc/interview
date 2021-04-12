package com.yl.learn.concurrent;

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
}
