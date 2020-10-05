package com.yl.learn.algorithm.kuaishou;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
 * 比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
 * 所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 来源：力扣（LeetCode）468
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidIPAddress extends TestCase {

    public void test() {
        validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

    public String validIPAddress(String IP) {
        List<String> ips = split(IP);
        if(ips == null) return "Neither";
        if(ips.size() == 4) return checkIp4(ips);
        else if(ips.size() == 8) return checkIp6(ips);
        else return "Neither";
    }

    private String checkIp6(List<String> ips) {
        for(int i = 0; i < ips.size(); i++) {
            String part = ips.get(i);
            if(!checkIp6(part)) return "Neither";
        }
        return "IPv6";
    }

    private boolean checkIp6(String part) {
        if(part.length() == 0 || part.length() > 4) return false;
        for(int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);
            if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
        }
        return true;
    }

    private String checkIp4(List<String> ips) {
        for(int i = 0; i < ips.size(); i++) {
            String part = ips.get(i);
            if(!checkIp4(part)) return "Neither";
        }
        return "IPv4";
    }

    private boolean checkIp4(String part) {
        if(part.length() == 0 || part.length() > 3) return false;
        if(part.charAt(0) == '0' && part.length() != 1) return false;
        int sum = 0;
        for(int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);
            if(c >= '0' && c <= '9') {
                sum = sum * 10 + (c - '0');
            }
            else return false;
        }
        return sum <= 255;
    }

    private List<String> split(String IP) {
        char[] ip = IP.toCharArray();
        char split = '-';
        List<String> rs = new ArrayList<>(8);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ip.length; i++) {
            if(ip[i] == '.' || ip[i] == ':') {
                if(split != '-' && split != ip[i]) return null;
                split = ip[i];
                rs.add(sb.toString());
                sb.delete(0, sb.length());
            }
            else sb.append(ip[i]);
        }
        rs.add(sb.toString());
        return rs;
    }
}
