package com.kevin.leetcode;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q363 {
    class Solution {

        int[][] sum;

        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = (m == 0) ? 0 : matrix[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            int ans = Integer.MIN_VALUE;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int p = i; p <= m; p++) {
                        for (int q = j; q <= n; q++) {
                            int v = sum[p][q] - sum[p][j - 1] - sum[i- 1][q] + sum[i - 1][j - 1];
                            if (v <= k) {
                                ans = Math.max(ans, v);
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}
