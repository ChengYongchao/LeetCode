package com.kevin.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q781 {
    static class Solution {
        public int numRabbits(int[] answers) {
            if (answers == null || answers.length == 0) {
                return 0;
            }
            Map<Integer, Integer> rabbit = new HashMap<>();
            int mix = 0;
            for (int i : answers) {
                if (i == 0) {
                    mix++;
                    continue;
                }
                if (!rabbit.containsKey(i)) {
                    mix += i + 1;
                    rabbit.put(i, i);
                } else {
                    int size = rabbit.get(i);
                    if (size == 0) {
                        mix += i + 1;
                        rabbit.put(i, i);
                    }else {
                        rabbit.put(i, size - 1);
                    }
                }

            }
            return mix;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRabbits(new int[]{2,1,2,2,2,2,2,2,1,1}));
    }
}
