package jz.newcode;

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

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == null) {
                tempA = headB;
            }
            if (tempB == null) {
                tempB = headA;
            }
        }

        return tempA;
    }
}
