package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/7/3
 */
public class _22_链表中倒数第k个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int skip = count - k;
        count = 0;
        temp = head;
        if (skip == 0) {
            return head;
        }

        while (temp != null) {
            if (count == skip) {
                ListNode tempHead = temp.next;
                temp.next = null;
                return tempHead;
            } else {
                count++;
                temp = temp.next;
            }
        }
        return null;
    }
}
