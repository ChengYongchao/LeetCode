package com.kevin.jianzhioffer.字符串;

import org.junit.Test;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class Q05 {
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            return s.replaceAll(" ", "%20");
        }

        public String replaceSpace2(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            StringBuilder res = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    res.append("%20");
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String res = solution.replaceSpace2("We are happy.");
    }

}
