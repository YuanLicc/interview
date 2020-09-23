package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）242
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram extends TestCase {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        if(s.length() == 0 && t.length() == 0) return true;

        Map<Character, Integer> map = new HashMap<>(s.length());

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i)) continue;

            op(map, s.charAt(i), true);
            op(map, t.charAt(i), false);
        }

        return map.isEmpty();
    }

    private void op(Map<Character, Integer> map, char aim, boolean isAdd) {
        Integer mapVal = map.get(aim);
        mapVal = mapVal == null ? 0 : mapVal;
        mapVal = isAdd ? mapVal + 1 : mapVal - 1;
        if(mapVal == 0) map.remove(aim);
        else map.put(aim, mapVal);
    }

    public void test() {
        isAnagram("123", "213");
    }
}
