package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/7/3
 */
public class _18_删除链表的值 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-3);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(-99);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        deleteNode(listNode, -3);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode tempHead = temp;
        while (temp.next != null) {
            if (temp.next.val == val) {
                ListNode next1 = temp.next;
                ListNode next = temp.next.next;
                temp.next = next;
                next1.next = null;
                return tempHead.next;
            } else {
                temp = temp.next;
            }
        }
        return tempHead.next;
    }
}
