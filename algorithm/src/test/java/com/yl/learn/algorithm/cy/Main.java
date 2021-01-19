package com.yl.learn.algorithm.cy;

import com.yl.learn.util.util.PrintUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        String[] num = line.split(" ");

        int sum = 0;
        int a = 0;
        for(int i = 0; i < num.length; i++) {
            sum += Integer.parseInt(num[i]);
        }

        PrintUtil.println(sum - (num.length - 1) * (num.length - 2) / 2);
    }

}
