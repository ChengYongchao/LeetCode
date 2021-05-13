package com.kevin.leetcode;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1269 {
    class Solution {

        int mod = (int) 1e9 + 7;

        public int numWays(int steps, int arrLen) {
            int max = Math.min(steps / 2, arrLen - 1);
            int[][] f = new int[2][max + 1];
            f[steps & 1][0] = 1;
            for (int i = steps - 1; i >= 0; i--) {
                int edge = Math.min(i, max);
                int a = i & 1;
                int b = (i + 1) & 1;
                for (int j = 0; j <= edge; j++) {
                    f[a][j] = 0;
                    f[a][j] = (f[a][j] + f[b][j]) % mod;
                    if (j - 1 >= 0) f[a][j] = (f[a][j] + f[b][j - 1]) % mod;
                    if (j + 1 <= max) f[a][j] = (f[a][j] + f[b][j + 1]) % mod;
                }
            }
            return f[0][0];
        }
    }
}
