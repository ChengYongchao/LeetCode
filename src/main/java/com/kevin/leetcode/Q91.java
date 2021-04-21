package com.kevin.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q91 {
    class Solution {
        /**
         * 动态规划
         *
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            int n = s.length();
            s = " " + s;
            char[] chars = s.toCharArray();
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int i = 1; i <= n; i++) {
                int a = chars[i] - '0';
                int b = (chars[i - 1] - '0') * 10 + chars[i] - '0';
                if (a >= 1 && a <= 9) {
                    f[i] = f[i - 1];
                }
                if (b >= 10 && b <= 26) {
                    f[i] += f[i - 2];
                }

            }
            return f[n];
        }

        /**
         * 动态规划并优化空间
         *
         * @param s
         * @return
         */
        public int numDecodings2(String s) {
            int n = s.length();
            s = " " + s;
            char[] chars = s.toCharArray();
            int[] f = new int[3];
            f[0] = 1;
            for (int i = 1; i <= n; i++) {
                f[i % 3] = 0;
                int a = chars[i] - '0';
                int b = (chars[i - 1] - '0') * 10 + chars[i] - '0';
                if (a >= 1 && a <= 9) {
                    f[i % 3] = f[(i - 1) % 3];
                }
                if (b >= 10 && b <= 26) {
                    f[i % 3] += f[(i - 2) % 3];
                }

            }
            return f[n % 3];
        }
    }
}
