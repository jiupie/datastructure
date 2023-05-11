package jz.carl.link;

/**
 * @author 南顾北衫
 * @date 2023/4/20
 */
public class _7_ {
    static class ListNode {
        ListNode next;
        int val;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;

        while (tempHeadA != tempHeadB) {
            tempHeadA = tempHeadA == null ? tempHeadB : tempHeadA.next;
            tempHeadB = tempHeadB == null ? tempHeadA : tempHeadB.next;
        }
        return tempHeadA;
    }
}
