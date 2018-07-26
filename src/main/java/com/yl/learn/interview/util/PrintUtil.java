package com.yl.learn.interview.util;

/**
 * 控制台输出工具类
 * @author YuanLi
 */
public class PrintUtil {

    public static void print(Object o) {
        System.out.print(o.toString());
    }

    public static void print(Object o, String prefix, String suffix) {
        System.out.print(prefix + o.toString() + suffix);
    }

    public static void printWithNaoTime(Object o, Timer timer) {
        System.out.print(o.toString() + ", nao time: " + timer.end());
    }

    public static void printWithNaoTime(Object o, Timer timer, String delimiter) {
        System.out.print(o.toString() + delimiter + timer.end());
    }

    public static void printWithNaoTime(Object o, Timer timer, String prefix, String delimiter, String suffix) {
        System.out.print(prefix + o.toString() + delimiter + timer.end() + suffix);
    }

    public static void println(Object o) {
        System.out.println(o.toString());
    }

    public static void println(Object o, String prefix, String suffix) {
        System.out.println(prefix + o.toString() + suffix);
    }

    public static void printlnWithNaoTime(Object o, Timer timer) {
        System.out.println(o.toString() + ", nao time: " + timer.end());
    }

    public static void printlnWithNaoTime(Object o, String delimiter, Timer timer) {
        System.out.println(o.toString() + delimiter + timer.end());
    }

    public static void printlnWithNaoTime(Object o, Timer timer, String prefix, String delimiter, String suffix) {
        System.out.println(prefix + o.toString() + delimiter + timer.end() + suffix);
    }
}
