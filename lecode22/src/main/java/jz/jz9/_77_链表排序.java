package jz.jz9;

/**
 * @author 南顾北衫
 */
public class _77_链表排序 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(4142);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(47);
        ListNode listNode3 = new ListNode(44);
        ListNode listNode4 = new ListNode(146);

        head.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode5 = sortList(head);

        System.out.println(listNode5.val);

    }


    public static class ListNode {
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


    public  static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = findMidNode(head);
        ListNode left = head;
        ListNode mid = midNode.next;
        midNode.next = null;

        return merge(sortList(left), sortList(mid));
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode head = null;
        ListNode p = null;
        while (left != null && right != null) {
            if (head == null) {
                if (left.val > right.val) {
                    head = right;
                    right = right.next;
                } else {
                    head = left;
                    left = left.next;
                }
                p = head;
            } else {
                if (left.val > right.val) {
                    p.next = right;
                    right = right.next;
                } else {
                    p.next = left;
                    left = left.next;
                }
                p=p.next;
            }
        }
        if (left == null) {
            p.next = right;
        } else {
            p.next = left;
        }
        return head;
    }

    public static ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
