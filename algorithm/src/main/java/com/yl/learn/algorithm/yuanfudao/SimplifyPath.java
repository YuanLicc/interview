package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠
 *
 * 来源：力扣（LeetCode）71
 * 链接：https://leetcode-cn.com/problems/simplify-path
 */
public class SimplifyPath extends TestCase {

    public String simplifyPath(String path) {
        if(path == null || path.length() == 0 || path.charAt(0) != '/') return "/";

        String[] ps = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < ps.length; i++) {
            if(i < ps.length - 1) {
                switch (ps[i + 1]) {
                    case "." : {
                        break;
                    }
                    case ".." : {
                        if(!stack.isEmpty()) stack.pop();
                        break;
                    }
                    case "" : {
                        break;
                    }
                    default: {
                        stack.push("/" + ps[i + 1]);
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append(s);
        }

        String rs = sb.toString();

        return rs.equals("") ? "/" : rs;
    }

    public void test() {
        PrintUtil.println(simplifyPath("/home/"));
        PrintUtil.println(simplifyPath("/../"));
        PrintUtil.println(simplifyPath("/home//foo"));
        PrintUtil.println(simplifyPath("/a/./b/../../c/"));
    }

}
