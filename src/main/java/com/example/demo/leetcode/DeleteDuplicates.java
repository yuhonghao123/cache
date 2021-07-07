package com.example.demo.leetcode;

/*
       存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表
 */
public class DeleteDuplicates {
    public ListNode2 deleteDuplicates(ListNode2 head) {
        if (head == null) {
            return head;
        }

        ListNode2 cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;

    }
}
