package com.yl.learn.lambda;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.Date;


public class ThreadLocalTest extends TestCase {
    public void testThreadLocal() {
        ThreadLocal<Date> local = ThreadLocal.withInitial(() -> {
            return new Date();
        });

        PrintUtil.println(local.get());
    }
}
