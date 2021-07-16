package com.example.demo.leetcode;

/*
    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 */
public class RemoveNthFromEnd {
    public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 dummy = new ListNode2(0, head);
        int length = getLength(head);
        ListNode2 cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode2 ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode2 head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
