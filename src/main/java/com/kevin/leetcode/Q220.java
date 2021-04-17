package com.kevin.leetcode;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q220 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Long> treeSet = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Long u = nums[i] * 1L;
                Long f = treeSet.floor(u);
                Long c = treeSet.ceiling(u);
                if (f != null && u - f <= t) {
                    return true;
                }
                if (c != null && c - u <= t) {
                    return true;
                }
                treeSet.add(u);
                if (i >= k) {
                    treeSet.remove(nums[i - k] * 1L);
                }
            }
            return false;
        }
    }
}
