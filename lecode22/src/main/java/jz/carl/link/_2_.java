package jz.carl.link;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @author 南顾北衫
 * @date 2023/4/19
 */
public class _2_ {
    public static class ListNode {
        private ListNode next;

        private int val;

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1, head);
        ListNode tempNode = newHead.next;
        ListNode lastNode = newHead;
        while (tempNode != null) {
            if (tempNode.val == val) {
                ListNode next1 = tempNode.next;
                lastNode.next = next1;
                tempNode = next1;
            } else {
                lastNode = tempNode;
                tempNode = tempNode.next;
            }
        }
        return newHead.next;
    }
}
