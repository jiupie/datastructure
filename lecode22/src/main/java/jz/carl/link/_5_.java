package jz.carl.link;

/**
 * @author 南顾北衫
 * @date 2023/4/19
 */
public class _5_ {
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

    public static void main(String[] args) {
        _5_ v = new _5_();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = v.swapPairs(listNode1);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode newHead = cur;
        ListNode lastNode = null;
        while (cur != null) {
            ListNode next = cur.next;
            //交换
            prev.next = next;
            cur.next = prev;

            //cur prev next
            if (lastNode != null) {
                lastNode.next = cur;
            }

            lastNode = prev;

            prev = next;
            if (prev == null) {
                return newHead;
            }
            cur = next.next;
        }


        return newHead;
    }
}
