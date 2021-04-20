package com.kevin.leetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q28 {
    class Solution {
        /**
         * KMP算法
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            //处理 needle = 0
            if (needle.length() == 0) {
                return 0;
            }
            int m = haystack.length();
            int n = needle.length();
            // 加空格保证前缀表消除 -1
            haystack = " " + haystack;
            needle = " " + needle;
            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();
            int[] next = new int[n + 1];
            //构造next表（前缀表）
            for (int i = 2, j = 0; i <= n; i++) {
                while (j > 0 && p[i] != p[j + 1]) {
                    j = next[j];
                }
                if (p[i] == p[j + 1]) {
                    j++;
                }
                next[i] = j;
            }
            for (int i = 1, j = 0; i <= m; i++) {
                while (j > 0 && s[i] != p[j + 1]) {
                    j = next[j];
                }
                if (s[i] == p[j + 1]) {
                    j++;
                }
                if (j == n) {
                    return i - n;
                }
            }
            return -1;
        }

    }
}
