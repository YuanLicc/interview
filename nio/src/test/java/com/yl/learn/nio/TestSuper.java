package com.yl.learn.nio;

import com.yl.learn.util.util.PrintUtil;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestSuper {

    private long time;

    private long mTime;

    @Before
    public void testStart() {
        time = System.nanoTime();
        mTime = System.currentTimeMillis();
    }

    @After
    public void testEnd() {
        PrintUtil.print(System.nanoTime() - time, "Elapsed Time: ", " ns");
        PrintUtil.print(System.currentTimeMillis() - mTime, "Elapsed Time: ", " ms");
    }

}
