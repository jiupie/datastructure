package jz.newcode.list;

/**
 * @author 南顾北衫
 * @date 2022/11/18
 */
public class _52_ {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(5);
        l.next = l1;

        ListNode intersectionNode = new _52_().getIntersectionNode(l,listNode1);

    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {

            if (tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }

            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }

        return tempA;
    }
}
