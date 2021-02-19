package com.yl.learn.nio;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

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
    
}
