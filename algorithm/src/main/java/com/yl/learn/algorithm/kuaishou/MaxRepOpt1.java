package com.yl.learn.algorithm.kuaishou;

public class MaxRepOpt1 {

    public int maxRepOpt1(String text) {
        int max = 1;
        for(int i = 0; i < text.length(); i++) {
            int cnt = 0;
            int len = 0;
            boolean is = false;
            for(int j = i + 1; j < text.length(); j++) {
                if(text.charAt(j) != text.charAt(i)) cnt++;
                else {
                    if(cnt >= 2) is = true;
                }
                if(cnt == 2) len = j - i - 1;
            }
            if(cnt >= 2 && is) max = max > len ? max : len;
            if(cnt == 1) max = max > (text.length() - 1 - i) ? max : (text.length() - 1 - i);
            if(cnt == 0) max = max > (text.length() - i) ? max : (text.length() - i);
        }
        return max;
    }

}
