package com.kevin.leetcode;

/**
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 * <p>
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1720 {
    static class Solution {
        /**
         * 根据题目给定的规则，利用如下异或性质从头做一遍即可：
         * <p>
         * 相同数值异或，结果为 00
         * 任意数值与 00 进行异或，结果为数值本身
         * 异或本身满足交换律
         * 已知 encoded[i-1] = arr[i-1] XOR arr[i]，将等式两边同时「异或」上 arr[i-1]。可得：
         * <p>
         * encoded[i-1] XOR arr[i-1] = arr[i-1] XOR arr[i] XOR arr[i-1]
         * 结合「性质三」和「性质一」，可化简「右式」得 encoded[i-1] XOR arr[i-1] = arr[i] XOR 0
         * 结合「性质二」，可化简「右式」得 encoded[i-1] XOR arr[i-1] = arr[i]
         * <p>
         * 作者：AC_OIer
         * 链接：https://leetcode-cn.com/problems/decode-xored-array/solution/gong-shui-san-xie-li-yong-yi-huo-xing-zh-p1bi/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param encoded
         * @param first
         * @return
         */
        public int[] decode(int[] encoded, int first) {
            int n = encoded.length + 1;
            int[] ans = new int[n];
            ans[0] = first;
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] ^ encoded[i - 1];
            }
            return ans;
        }
    }
}
