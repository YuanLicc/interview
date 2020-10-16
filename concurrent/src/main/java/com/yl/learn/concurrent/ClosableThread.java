package com.yl.learn.concurrent;

public class ClosableThread extends Thread{
    private boolean isStop = false;
    public void run() {
        while (!isStop) {
            // 非阻塞代码，若此处代码块存在阻塞，调用 stopThread() 方法，
            // 线程不能及时响应，或者永远阻塞住，无法关闭
        }
    }
    public void stopThread() {
        isStop = true;
    }
}
