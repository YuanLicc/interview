package com.yl.learn.interview.neteasy;

public class WorkDevide {

    static int a;

    static int c;

    public static int ss() {
        c++;
        return c;
    }

    public static void main(String[] args) {
        WorkDevide workDevide = new WorkDevide();

        System.out.println(workDevide.aa());
        System.out.println(a);

        System.out.println(ss());
    }

    public int aa() {
        a++;
        return a;
    }

}
