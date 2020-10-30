
package com.kevin.jianzhioffer.stack;

import java.util.Stack;

/**
 * 在这里加入功能说明
 *
 * @author chengyongchao
 * @version 1.0, 2020年10月28日
 */
/*
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class Q09
{
    class CQueue
    {
        private Stack<Integer> stack1 = new Stack<>();

        private Stack<Integer> stack2 = new Stack<>();

        public CQueue()
        {

        }

        public void appendTail(int value)
        {
            this.stack1.add(value);
        }

        public int deleteHead()
        {
            if(stack1.isEmpty())
            {
                return -1;
            }
            
            while(!this.stack1.isEmpty())
            {
                this.stack2.add(stack1.pop());
            }
            int res = this.stack2.pop();
            while(!this.stack2.isEmpty())
            {
                this.stack1.add(this.stack2.pop());
            }
            return res;

        }
    }
}
