package com.kevin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q137 {
    static class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Integer i : map.keySet()) {
                if (map.get(i) == 1) return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
    }
}
