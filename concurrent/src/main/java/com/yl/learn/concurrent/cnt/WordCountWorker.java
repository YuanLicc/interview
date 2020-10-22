package com.yl.learn.concurrent.cnt;

import java.io.*;
import java.util.concurrent.CountDownLatch;

public class WordCountWorker implements Runnable {
    
    private CountDownLatch countDownLatch;
    
    private volatile int cnt = 0;
    private String fileName;
    private final static String CLASSPATH = WordCountWorker.class.getResource("/").getPath();
    
    public WordCountWorker(String fileName, CountDownLatch countDownLatch) {
        this.fileName = fileName;
        this.countDownLatch = countDownLatch;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(CLASSPATH + fileName)));
            String line = null;
            while ((line = bis.readLine()) != null) {
                cnt += line.split(" ").length;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            countDownLatch.countDown();
        }
    }
    
    public int getCnt() {return cnt;}
}
