package jz.newcode;

/**
 * @author 南顾北衫
 * @date 2022/11/17
 */
public class _24_反转链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return rec(head);
    }


    /**
     * 1->2->3->4->5
     * t  s  f
     * 1<-2  3->4->5
     * s  f
     * 双指针
     */
    public ListNode fastSlow(ListNode node) {
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null) {
            ListNode tempNode = slow;
            slow = fast;
            fast = fast.next;

            if (tempNode.next == slow) {
                tempNode.next = null;
            }

            slow.next = tempNode;
        }
        return slow;
    }


    /**
     * 递归
     */
    private ListNode rec(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode tempNode = node.next;
        ListNode rec = rec(tempNode);

        node.next = null;
        tempNode.next = node;
        return rec;
    }
}
