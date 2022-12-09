package jz.newcode.list;

/**
 * @author 南顾北衫
 * @date 2022/11/15
 */
public class _22_链表中倒数第k个节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        _22_链表中倒数第k个节点 v = new _22_链表中倒数第k个节点();
        ListNode kthFromEnd = v.getKthFromEnd(listNode, 1);
        int val = kthFromEnd.val;
        System.out.println(val);
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode[] rec = rec(head, 0, k);
//        return rec[rec.length - k];

        return pointer(head, k);
    }

    /**
     * 快慢指针
     */
    public ListNode pointer(ListNode node, int k) {
        if (node == null) {
            return null;
        }

        ListNode kNode = node;
        ListNode mNode = node;
        for (int i = 1; i <= k; i++) {
            kNode = kNode.next;
        }

        if (kNode == null) {
            return mNode;
        }

        while (kNode != null) {
            mNode = mNode.next;
            kNode = kNode.next;
        }
        return mNode;
    }


    /**
     * 递归
     */
    private ListNode[] rec(ListNode node, int i, int k) {
        if (node == null) {
            return new ListNode[i];
        }
        ListNode tempNode = node.next;
        ListNode[] rec = rec(tempNode, i + 1, k);
        rec[i] = node;
        return rec;
    }
}
