package com.yl.learn.concurrent;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;
import java.security.MessageDigest;

public class MangeTests extends TestCase {
    
    
    public void testMD5() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update("aaaa".getBytes());
        PrintUtil.println(new String(messageDigest.digest()));
        messageDigest.update(messageDigest.digest());
        PrintUtil.println(new String(messageDigest.digest()));
    }
}
