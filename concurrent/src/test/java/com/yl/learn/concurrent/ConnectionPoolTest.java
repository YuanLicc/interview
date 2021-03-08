package com.yl.learn.concurrent;

import com.yl.learn.concurrent.connect.database.ConnectionPool;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ConnectionPoolTest extends TestCase {

    static class SleepRunnable implements Runnable {

        private ConnectionPool pool;

        public SleepRunnable(ConnectionPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            try {
                Timer timer = Timer.start();
                ConnectionPool.Connection connection = pool.get(1);

                if(connection != null) {
                    pool.release(connection);
                    PrintUtil.println("Thread Name: " + Thread.currentThread().getName() + ", time: " + timer.end());
                }
                else {
                    PrintUtil.println("Thread Name: " + Thread.currentThread().getName() + ", get null");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testConnectionPool() throws Exception{

        ConnectionPool pool = new ConnectionPool(10);

        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(new SleepRunnable(pool), i + "");
            thread.start();
        }
        pool.get(-1);
    }
    
    public void testExecutors() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        
        FutureTask<String> task = (FutureTask<String>) service.submit(new Run(), "success");
        
        PrintUtil.print(task.get());
    }
    
    class Run implements Runnable {
    
        @Override
        public void run() {
            PrintUtil.print("RUN");
        }
    }

}
