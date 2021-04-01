package com.kevin.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 * <p>
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 * <p>
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * <p>
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 * <p>
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：4
 * 输出：7
 * 解释：7 = 4 * 3 / 2 + 1
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：12
 * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10000
 * -2^31 <= answer <= 2^31 - 1  （答案保证符合 32 位整数。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clumsy-factorial
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1006 {
    static class Solution {
        public int clumsy(int N) {
            Deque<Integer> nums = new ArrayDeque<>();
            Deque<Character> ops = new ArrayDeque<>();
            Map<Character, Integer> map = new HashMap<>();
            map.put('+', 1);
            map.put('-', 1);
            map.put('*', 2);
            map.put('/', 2);
            char[] cs = new char[]{'*', '/', '+', '-'};
            for (int i = N, j = 0; i > 0; i--, j++) {
                char op = cs[j % 4];
                nums.addLast(i);
                while (!ops.isEmpty() && map.get(op) <= map.get(ops.peekLast())) {
                    calc(nums, ops);
                }
                if (i != 1) ops.add(op);
            }
            while (!ops.isEmpty()) calc(nums, ops);
            return nums.peekLast();
        }

        public void calc(Deque<Integer> nums, Deque<Character> ops) {
            int b = nums.pollLast();
            int a = nums.pollLast();
            char op = ops.pollLast();
            int res = 0;
            switch (op) {
                case '+':
                    res = a + b;
                    break;
                case '-':
                    res = a - b;
                    break;
                case '*':
                    res = a * b;
                    break;
                case '/':
                    res = a / b;
            }
            nums.addLast(res);
        }
    }
}
