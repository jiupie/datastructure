package jz.carl.link;

/**
 * @author 南顾北衫
 * @date 2023/4/19
 */
public class _4_ {
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

    public ListNode reverseList(ListNode head) {

        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        //node:4        3
        //next:null     4
        ListNode next = node.next;
        ListNode head = reverse(next);
        //1->2->3->4->null
        if (next != null) {
            next.next = node;
            node.next = null;
        }
        if (next == null) {
            return node;
        }
        return head;
    }
}
