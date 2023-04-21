package jz.carl.link;

/**
 * @author 南顾北衫
 * @date 2023/4/19
 */
public class _6_ {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //head = [-1,1,2,3,4,5], n = 2
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode slow = dummyNode;

        ListNode tempNode = dummyNode;
        for (int i = 0; i < n; i++) {
            tempNode = tempNode.next;
        }

        while (tempNode.next != null) {
            tempNode = tempNode.next;
            slow = slow.next;
        }
        ListNode next = slow.next.next;
        slow.next = next;
        slow.next.next = null;
        return dummyNode.next;
    }

}
