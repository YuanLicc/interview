package com.yl.learn.concurrent;

import com.yl.learn.concurrent.util.ThreadUtils;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class ThreadLocalTest extends TestCase {

    public void testThreadLocal() {
        Timer timer = Timer.start();

        ThreadUtils.sleepSecond(1);

        PrintUtil.println(timer.end());
    }
}
