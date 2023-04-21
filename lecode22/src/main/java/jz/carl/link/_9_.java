package jz.carl.link;

/**
 * 链排
 *
 * @author 南顾北衫
 * @date 2023/4/20
 */
public class _9_ {
    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        _9_ v = new _9_();
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode s = v.s(listNode);

    }


    public ListNode s(ListNode node) {
        return divid(node);
    }

    //1->2->3->4
    public ListNode divid(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode midNode = mid(node);
        ListNode next = midNode.next;
        midNode.next = null;

        return mergeAll(divid(node), divid(next));
    }

    private ListNode mergeAll(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(-1);
        ListNode listNode = newHead;

        while (left != null && right != null) {
            if (left.val >= right.val) {
                listNode.next = right;
                listNode = right;
                ListNode next = right.next;
                right.next = null;
                right = next;
            } else {
                listNode.next = left;
                listNode = left;
                ListNode next = left.next;
                left.next = null;
                left = next;
            }
        }
        if (left != null) {
            listNode.next = left;
        }
        if (right != null) {
            listNode.next = right;
        }
        return newHead.next;
    }


    public ListNode mid(ListNode node) {
        ListNode dummry = new ListNode(-1);
        dummry.next = node;
        ListNode slow = dummry;
        ListNode fast = dummry;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
