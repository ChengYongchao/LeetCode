package com.kevin.leetcode;

public class Q1011 {
    static class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int l = 0, r = 0;
            for (int w : weights) {
                l = Math.max(l, w);
                r += w;
            }

            while (l < r) {
                int mid = (l + r) >> 1;
                if (check(weights, mid, D)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }

        private boolean check(int[] weights, int mid, int d) {
            int len = weights.length;
            int day = 1, sum = 0;
            for (int weight : weights) {
                if (sum + weight <= mid) {
                    sum += weight;
                } else {
                    sum = weight;
                    day++;
                }
            }
            return day <= d;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));

    }
}
