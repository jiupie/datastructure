package com.wl;

/**
 * 链表排序
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class LinkedSort {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(0);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode1 = sortList(listNode);
    }

    private static ListNode sortList(ListNode head) {
        //先递归分割
        if (head == null || head.next == null) {
            return head;
        }
        ListNode header = split(head);

        //左半段
        ListNode leftNode = sortList(head);
        //右半段
        ListNode rightNode = sortList(header);

        //合并
        return merge(leftNode, rightNode);
    }

    private static ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode listNode = new ListNode(0);
        ListNode p = listNode;
        while (rightNode != null && leftNode != null) {
            if (rightNode.val > leftNode.val) {
                p.next = leftNode;
                leftNode = leftNode.next;
                p = p.next;
            } else {
                p.next = rightNode;
                rightNode = rightNode.next;
                p = p.next;
            }
        }
        if (rightNode != null) {
            p.next = rightNode;
        }
        if (leftNode != null) {
            p.next = leftNode;
        }
        return listNode.next;
    }

    private static ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;

            fast = fast.next.next;
        }
        //断
        pre.next = null;
        return slow;
    }


}
