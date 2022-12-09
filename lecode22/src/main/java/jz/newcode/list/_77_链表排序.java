package jz.newcode.list;

/**
 * @author 南顾北衫
 * @date 2022/12/5
 */
public class _77_链表排序 {

    static class ListNode {
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

    //归并排序
    ListNode mergeSort(ListNode head) {
        return spilt(head);
    }

    //找中间节点
    //使用快慢指针
    ListNode midNode(ListNode node) {
        ListNode tempNode = node;
        ListNode last = tempNode;
        while (tempNode != null && tempNode.next != null && tempNode.next.next != null) {
            last = last.next;
            tempNode = tempNode.next.next;
        }
        return last;
    }

    //分割
    private ListNode spilt(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode midNode = midNode(head);
        ListNode next = midNode.next;
        midNode.next = null;

        return sort(spilt(head), spilt(next));
    }

    //排序
    private ListNode sort(ListNode head, ListNode tail) {
        ListNode tempHead = new ListNode();
        ListNode res = tempHead;
        ListNode leftNode = head;
        ListNode rightNode = tail;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val > rightNode.val) {
                res.next = rightNode;
                ListNode next = rightNode.next;
                rightNode.next = null;
                rightNode = next;
            } else {
                res.next = leftNode;
                ListNode next = leftNode.next;
                leftNode.next = null;
                leftNode = next;
            }
            res = res.next;
        }
        if (leftNode == null) {
            res.next = rightNode;
        } else {
            res.next = leftNode;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        _77_链表排序 v = new _77_链表排序();
        ListNode res = v.mergeSort(listNode);
        System.out.println(res);

    }
}



