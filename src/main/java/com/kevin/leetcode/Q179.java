package com.kevin.leetcode;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chengyongchao
 */
public class Q179 {
    class Solution {
        public String largestNumber(int[] nums) {
            String[] s1 = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                s1[i] = "" + nums[i];
            }
            Arrays.sort(s1, (a, b) -> {
                String a1 = a + b;
                String a2 = b + a;
                return a2.compareTo(a1);
            });
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < s1.length; i++) {
                s2.append(s1[i]);
            }
            int l = s2.length() - 1;
            int i = 0;
            while (i < l && s2.charAt(i) == '0') {
                i++;
            }
            return s2.substring(i);
        }
    }
}
