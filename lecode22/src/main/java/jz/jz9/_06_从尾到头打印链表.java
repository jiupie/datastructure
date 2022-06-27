package jz.jz9;

/**
 * @author 南顾北衫
 */
public class _06_从尾到头打印链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        int count = 0;
        ListNode tail = head;

        while (tail != null) {
            count++;
            tail = tail.next;
        }

        int[] ints = new int[count+1];
        while (head != null) {
            ints[--count] = head.val;
            head = head.next;
        }

        return ints;
    }

}
