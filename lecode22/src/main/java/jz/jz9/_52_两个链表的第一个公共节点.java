package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/7/3
 */
public class _52_两个链表的第一个公共节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) {
                 tempA=headB;
            } else {
                tempA = tempA.next;
            }
            if (tempB == null) {
                 tempB=headA;
            } else {
                tempB = tempB.next;
            }
        }
        return tempA;
    }
}
