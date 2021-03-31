package com.kevin.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q90 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> res = new HashSet<>();
            List<Integer> arr = new ArrayList<>();
            dfs(nums, 0, arr, res);
            return new ArrayList<>(res);
        }

        public void dfs(int[] nums, int index, List<Integer> arr, Set<List<Integer>> res) {
            if (index == nums.length) {
                res.add(new ArrayList<>(arr));
                return;
            }
            arr.add(nums[index]);
            dfs(nums, index+1, arr, res);
            arr.remove(arr.size() - 1);
            dfs(nums, index+1, arr, res);
        }
    }
}
