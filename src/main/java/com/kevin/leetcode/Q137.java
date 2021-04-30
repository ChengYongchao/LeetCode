package com.kevin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q137 {
    static class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Integer i : map.keySet()) {
                if (map.get(i) == 1) return i;
            }
            return -1;
        }
    }
}
