package com.kevin.jianzhioffer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q17 {
    class Solution {
        private int[] res;
        private int nine = 0, count = 0, start, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public int[] printNumbers(int n) {
            this.n = n;
            this.res = new int[(int) Math.pow(10, n) - 1];
            num = new char[n];
            start = n - 1;
            dfs(0);
            return res;
        }

        void dfs(int x) {
            if (x == n) {
                String s = String.valueOf(num).substring(start);
                if (!s.equals("0")) res[count++] = Integer.parseInt(s);
                if (n - start == nine) start--;
                return;
            }
            for (char i : loop) {
                if (i == '9') nine++;
                num[x] = i;
                dfs(x + 1);
            }
            nine--;
        }
    }
}
