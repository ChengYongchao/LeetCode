package com.kevin.leetcode;

import com.kevin.util.ListNode;

public class Q82 {
    /**
     * 几乎所有的链表题目，都具有相似的解题思路。
     * <p>
     * 建一个「虚拟头节点」dummy 以减少边界判断，往后的答案链表会接在 dummy 后面
     * <p>
     * 使用 tail 代表当前有效链表的结尾
     * <p>
     * 通过原输入的 head 指针进行链表扫描
     * <p>
     * 我们会确保「进入外层循环时 head 不会与上一节点相同」，因此插入时机：
     * <p>
     * head 已经没有下一个节点，head 可以被插入
     * <p>
     * head 有一下个节点，但是值与 head 不相同，head 可以被插入
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/tong-yong-shan-chu-zhong-fu-jie-dian-lia-od9g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while (head != null) {
                if (head.next == null || head.val != head.next.val) {
                    tail.next = head;
                    tail = head;
                }
                while (head.next != null && head.val == head.next.val) head = head.next;
                head = head.next;
            }
            tail.next =null;
            return dummy.next;
        }
    }
}
