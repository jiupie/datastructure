package jz.carl.link;

/**
 * @author 南顾北衫
 * @date 2023/4/19
 */
public class _3_ {


    class MyLinkedList {
        class ListNode {
            int val;
            ListNode prev;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }

        ListNode head;
        ListNode tail;
        int size;

        public MyLinkedList() {
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        public int get(int index) {
            if (index > size) {
                return -1;
            }
            ListNode node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            ListNode node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            ListNode listNode = new ListNode(val);
            ListNode prev = node.prev;
            size++;
            listNode.next = node;
            listNode.prev = prev;
            node.prev = listNode;
            prev.next = listNode;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            size--;
            ListNode next = node.next;
            ListNode prev = node.prev;
            node.next = null;
            node.prev = null;
            next.prev = prev;
            prev.next = next;
        }
    }
}
