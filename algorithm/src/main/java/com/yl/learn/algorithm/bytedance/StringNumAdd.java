package com.yl.learn.algorithm.bytedance;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）415
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringNumAdd {
    
    public String addStrings(String num1, String num2) {
        char[] maxS = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] minS = num1.length() <= num2.length() ? num1.toCharArray() : num2.toCharArray();
        
        char[] rs = new char[maxS.length];
        
        int maxIndex = maxS.length - 1;
        int minIndex = minS.length - 1;
        
        int isUp = 0;
        while (minIndex >= 0) {
            int sum = (maxS[maxIndex] - '0') + (minS[minIndex] - '0') + isUp;
            rs[maxIndex] = (char)(sum % 10 + '0');
            isUp = sum / 10;
            minIndex--;
            maxIndex--;
        }
        
        while (maxIndex >= 0) {
            int sum = maxS[maxIndex] - '0' + isUp;
            rs[maxIndex] = (char)(sum % 10 + '0');
            isUp = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        if(isUp == 1) sb.append(1);
        sb.append(rs);
        return sb.toString();
    }
    
}
