package 剑指offer;


/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _25_合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(mergeTwoLists(listNode, listNode4));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        //1->4, 1->3->4
        //1->1->4
        ListNode temp = t1;
        while (t2.next != null) {
            if (t1.val <= t2.val) {
                t2.next = t1.next;
                t1.next = t2;
                temp = t1;
                t1 = t1.next;
                t2 = t2.next;
            } else {
                t2.next = temp.next;
                temp.next = t2;
                temp = t1;
                t1 = t1.next;
                t2 = t2.next;
            }
        }

        return t1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}