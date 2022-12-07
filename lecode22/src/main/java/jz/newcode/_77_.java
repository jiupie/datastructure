package jz.newcode;

/**
 * @author 南顾北衫
 * @date 2022/12/5
 */
public class _77_ {

    public class ListNode {
        int val;
        ListNode next;

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

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node;
        ListNode tempHeadNode = head;
        ListNode tempNode;
        ListNode lastTail = null;

        while (tempHeadNode.next != null) {
            node = head.next;
            tempNode = head;
            while (node != null) {
                if (tempNode.val < node.val) {
                    tempNode = node;
                }
                if (lastTail == node.next) {
                    break;
                } else {
                    node = node.next;
                }
            }
            lastTail = node;
            int val = tempNode.val;
            tempNode.val = lastTail.val;
            lastTail.val = val;
        }

        return head;
    }

}



