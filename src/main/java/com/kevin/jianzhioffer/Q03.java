package com.kevin.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Q03 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            int repeat = -1;
            if (nums == null || nums.length == 0) {
                return repeat;
            }
            Set<Integer> set = new HashSet(nums.length);
            for (int num : nums) {
                if (!set.add(num)) {
                    repeat = num;
                    break;
                }
            }
            return repeat;
        }

        /**
         * 使用数组替换set
         * @param nums
         * @return
         */
        public int findRepeatNumber2(int[] nums) {

            if (nums == null || nums.length == 0) {
                return -1;
            }
            int [] arr = new int[nums.length];
            for(int i =0; i < nums.length; i++)
            {
                if(arr[nums[i]] == 1){
                    return nums[i];
                }
                arr[nums[i]] = 1;
            }
            return -1;
        }
    }
}
