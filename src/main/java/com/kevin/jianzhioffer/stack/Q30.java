
package com.kevin.jianzhioffer.stack;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

/**
 * 在这里加入功能说明
 *
 * @author chengyongchao
 * @version 1.0, 2020年10月28日
 */
public class Q30
{
    /*
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是
     * O(1)。
     */
    public static class MinStack
    {

        private Stack<Integer> stack1 = new Stack<>();

        private Stack<Integer> stack2 = new Stack<>();

        private int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack()
        {

        }

        public void push(int x)
        {
            stack1.push(x);
            if (x <= min)
            {
                min = x;
                stack2.push(x);
            }
            else
            {
                stack2.push(min);
            }
        }

        public void pop()
        {
            stack1.pop();
            stack2.pop();
            if (stack2.isEmpty())
            {
                min = Integer.MAX_VALUE;
            }
            else
            {
                min = stack2.peek();
            }
        }

        public int top()
        {
            return stack1.peek();
        }

        public int min()
        {
            return stack2.peek();
        }
    }

    private MinStack stack;

    @Before
    public void before()
    {
        stack = new MinStack();
    }

    @Test
    public void test1()
    {

        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        int x1 = stack.top();
        stack.pop();
        int x2 = stack.min();
        stack.pop();
        int x3 = stack.min();
        stack.pop();
        stack.push(2147483647);
        int x4 = stack.top();
        int x5 = stack.min();
        stack.push(-2147483648);
        int x6 = stack.top();
        int x7 = stack.min();
        stack.pop();
        int x8 = stack.min();
    }

    @Test
    public void test2()
    {
        stack.push(-10);
        stack.push(14);
        int x1 = stack.min();
        int x2 = stack.min();
        stack.push(-20);
        int x3 = stack.min();
        int x4 = stack.min();
        int x5 = stack.top();
        int x6 = stack.min();
        stack.pop();
        stack.push(10);
        stack.push(-7);
        int x7 = stack.min();
        stack.push(-7);
        stack.pop();
        int x8 = stack.top();
        int x9 = stack.min();
        stack.pop();
    }
}
