package com.kevin.jianzhioffer.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q06 {

    /*Definition for singly-linked list.*/

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * 递归
         *
         * @param head
         * @return
         */
        List<Integer> tmp = new ArrayList<>();

        public int[] reversePrint(ListNode head) {
            recur(head);
            int[] result = new int[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) {
                result[i] = tmp.get(i);
            }
            return result;
        }

        public void recur(ListNode head) {
            if (head == null) {
                return;
            }
            recur(head.next);
            tmp.add(head.val);
        }

        /**
         * 辅助栈
         */
        public int[] reversePrint2(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode temp = head;
            while (temp != null) {
               stack.push(temp);
               temp = temp.next;
            }
            int size = stack.size();
            int[] result = new int[size];
            for (int i = 0; i < size; i++) {
                result[i] = stack.pop().val;
            }
            return result;
        }
    }
}
