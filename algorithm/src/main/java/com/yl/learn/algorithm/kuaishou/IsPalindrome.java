package com.yl.learn.algorithm.kuaishou;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）9
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        int wei = wei(x);
        int start = 1;
        int end = wei;
        while (start < end) {
            if(get(x, start) != get(x, end)) return false;
            end--;
            start++;
        }
        return true;
    }

    public boolean isPalindromeReverse(int x) {
        if(x < 0) return false;
        int r = reverse(x);
        while (x > 0) {
            if(x % 10 != r % 10) return false;
            x = x / 10;
            r = r / 10;
        }
        return true;
    }

    private int reverse(int x) {
        int rs = 0;
        while (x > 0) {
            rs = rs * 10 + (x % 10);
            x = x / 10;
        }
        return rs;
    }

    private int get(int x, int wei) {
        return (int) (x / Math.pow(10, wei - 1)) % 10;
    }

    private int wei(int x) {
        int cnt = 0;
        while (x > 0) {
            x = x / 10;
            cnt++;
        }
        return cnt;
    }
}
