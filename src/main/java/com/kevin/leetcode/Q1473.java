package com.kevin.leetcode;

public class Q1473 {
    static class Solution {

        private static final int INF = 0x3f3f3f3f;

        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            int[][][] f = new int[m + 1][n + 1][target + 1];
            //不存在分区数量为零的情况
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    f[i][j][0] = INF;
                }
            }
            for (int i = 1; i <= m; i++) {
                int color = houses[i - 1];
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= target; k++) {
                        if (k > i) {
                            f[i][j][k] = INF;
                            continue;
                        }
                        //房间已经上色
                        if (color != 0) {
                            if (j == color) {
                                int temp = INF;
                                //从构成新分区中选最优
                                for (int l = 1; l <= n; l++) {
                                    if (l != j) {
                                        temp = Math.min(temp, f[i - 1][l][k - 1]);
                                    }
                                }
                                //从不构成新分区中选最优
                                f[i][j][k] = Math.min(temp, f[i - 1][j][k]);
                            } else {
                                f[i][j][k] = INF;
                            }
                        } else {
                            //第i间房间没有上色
                            int u = cost[i - 1][j - 1];
                            int temp = INF;
                            //从构成新分区中选最优
                            for (int l = 1; l <= n; l++) {
                                if (l != j) {
                                    temp = Math.min(temp, f[i - 1][l][k - 1]);
                                }
                            }
                            //从不构成新分区中选最优
                            f[i][j][k] = Math.min(temp, f[i - 1][j][k]) + u;
                        }
                    }
                }
            }
            int res = INF;
            for (int i = 1; i <= n; i++) {
                res = Math.min(res, f[m][i][target]);
            }
            return res == INF ? -1 : res;
        }
    }
}
