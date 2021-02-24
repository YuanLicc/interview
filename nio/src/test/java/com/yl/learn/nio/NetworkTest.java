package com.yl.learn.nio;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.io.*;
import java.net.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Objects;

public class NetworkTest extends TestCase {
    
    public void testInterface() throws SocketException {
        Enumeration<NetworkInterface> ins = NetworkInterface.getNetworkInterfaces();
        while (ins != null && ins.hasMoreElements()) {
            NetworkInterface item = ins.nextElement();
            Enumeration<InetAddress> addrs = item.getInetAddresses();
            while (addrs.hasMoreElements()) {
                InetAddress address = addrs.nextElement();
                PrintUtil.println(address.getHostAddress());
                PrintUtil.println(address.getHostName());
            }
        }
    }
    
    public void testFileChannel() throws URISyntaxException, IOException {
        URI uri = Objects.requireNonNull(NetworkTest.class.getClassLoader().getResource("test.txt")).toURI();
        FileChannel fileChannel = FileChannel.open(Paths.get(uri));
        FileChannel wirChannel = FileChannel.open(Paths.get(NetworkTest.class.getClassLoader().getResource("test1.txt").toURI()), StandardOpenOption.WRITE);
        fileChannel.transferTo(0, fileChannel.size(), wirChannel);
        wirChannel.close();
        fileChannel.close();
    }
    
}
