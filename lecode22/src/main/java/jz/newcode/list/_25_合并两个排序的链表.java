package jz.newcode.list;

/**
 * @author 南顾北衫
 * @date 2022/11/18
 */
public class _25_合并两个排序的链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 伪头点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tempHead = head;

        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 <= val2) {
                tempHead.next = l1;
                l1 = l1.next;
                tempHead.next.next = null;
            } else {
                tempHead.next = l2;
                l2 = l2.next;
                tempHead.next.next = null;
            }
            tempHead = tempHead.next;
        }
        tempHead.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
