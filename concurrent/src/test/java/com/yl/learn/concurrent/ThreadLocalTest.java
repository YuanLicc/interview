package com.yl.learn.concurrent;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.lang.reflect.Field;

public class ThreadLocalTest extends TestCase {

    public void testThreadLocal() {
        
        new OwnThread().start();
        
    }
    
    class OwnThread extends Thread {
        
        public void run() {
    
            ThreadLocal<String> user = new ThreadLocal<>();
            user.set("user1");
    
            ThreadLocal<String> name = new ThreadLocal<>();
            name.set("name1");
            
            Field field = null;
            try {
                field = Thread.class.getDeclaredField("threadLocals");
                field.setAccessible(true);
                Object object = field.get(this);
                PrintUtil.print(object);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
    
        }
        
    }
    
    
}
