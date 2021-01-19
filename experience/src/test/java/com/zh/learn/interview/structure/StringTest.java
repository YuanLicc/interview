package com.zh.learn.interview.structure;

import com.yl.learn.util.util.PrintUtil;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by hong on 2018/9/7.
 */
public class StringTest {

    public void formatTest() {
        String str = String.format("你好,%9.2f",1234563.25);
        PrintUtil.println(str);

        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        PrintUtil.println(a);
    }

    public static void main(String[] args) {
        new StringTest().formatTest();
    }

}
