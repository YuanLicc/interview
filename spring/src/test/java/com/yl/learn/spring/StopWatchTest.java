package com.yl.learn.spring;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;
import org.springframework.util.StopWatch;

public class StopWatchTest extends TestCase {
    
    public void test() {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start("test");
            Thread.sleep(1000);
            stopWatch.stop();
    
            stopWatch.start("test1");
            Thread.sleep(1000);
            stopWatch.stop();
            PrintUtil.println(stopWatch.prettyPrint());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
