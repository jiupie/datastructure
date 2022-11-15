package jz.newcode;

/**
 * @author 南顾北衫
 * @date 2022/11/15
 */
public class _18_删除链表的节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode tempNode = tempHead;

        while (tempNode.next != null) {
            int target = tempNode.next.val;
            if (val == target) {
                ListNode nextNode = tempNode.next;
                ListNode node = nextNode.next;
                tempNode.next = node;
                nextNode = null;
                return tempHead.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        return null;
    }
}
