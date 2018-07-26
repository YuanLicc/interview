package com.yl.learn.algorithm.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Two {

    public static String replaceStr(StringBuffer replaced, String replace) {
        if(replaced == null) {
            return null;
        }
        return Arrays.asList(replaced.toString().split(" ")).stream().collect(Collectors.joining("%20"));
    }

    public static String replaceSpace(StringBuffer replaced, String replace) {
        if(replaced == null) {
            return null;
        }

        StringBuffer temp = new StringBuffer();

        for(int i = 0; i < replaced.length(); i++) {
            char current = replaced.charAt(i);
            if(current == ' ') {
                temp.append(replace);
            }
            else {
                temp.append(current);
            }
        }
        return temp.toString();
    }

}
