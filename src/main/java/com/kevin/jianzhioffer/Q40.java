package com.kevin.jianzhioffer;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q40 {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr == null || arr.length == 0) return new int[0];
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int num : arr) {
                pq.add(num);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = pq.remove();
            }
            return res;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        s.getLeastNumbers(new int[]{1, 2, 3}, 2);
    }
}
