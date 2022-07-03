package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/7/3
 */
public class _25_合并两个排序的链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode p = null;
        while (temp1 != null && temp2 != null) {
            if (head == null) {
                if (temp1.val > temp2.val) {
                    head = temp2;
                    ListNode next = temp2.next;
                    temp2.next = null;
                    temp2 = next;
                } else {
                    head = temp1;
                    ListNode next = temp1.next;
                    temp1.next = null;
                    temp1 = next;
                }
                p = head;
            } else {
                if (temp1.val > temp2.val) {
                    p.next = temp2;
                    ListNode next = temp2.next;
                    temp2.next = null;
                    temp2 = next;
                } else {
                    p.next = temp1;
                    ListNode next = temp1.next;
                    temp1.next = null;
                    temp1 = next;
                }
                p = p.next;
            }
        }

        if (temp2 != null) {
            p.next = temp2;
        }
        if (temp1 != null) {
            p.next = temp1;
        }

        return head;
    }
}
