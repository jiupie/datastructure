package jz.newcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 南顾北衫
 * @date 2022/11/15
 */
public class _06_从尾到头打印链表 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        _06_从尾到头打印链表 v = new _06_从尾到头打印链表();
//        int[] ints = v.reversePrint(listNode);
//        int[] ints = v.headInsert(listNode);
        int[] ints = v.stack(listNode);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 递归
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        //递归
        return rec(head, 0);
    }

    //递归 参数（调用时传入，可以当作临时保存每个阶段的变量值）  结束条件（结束递归）  返回值（返回一个值，在递归结束后可以使用）
    //递归方法的参数  保存的都是调用时候传入的
    //注意：递归结束条件 最后一个返回值 用处非常大
    public int[] rec(ListNode node, int count) {
        //结束条件
        if (node == null) {
            return new int[count];
        }
        //条件变更
        ListNode next = node.next;
        count++;
        int[] rec = rec(next, count);

        int i = rec.length - count;
        rec[i] = node.val;
        return rec;
    }


    /**
     * 头插法
     *
     * @return
     */
    public int[] headInsert(ListNode head) {
        ListNode tempHeadNode = new ListNode(0);

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            ListNode tempHeadNodeNext = tempHeadNode.next;
            ListNode tempNext = temp.next;
            tempHeadNode.next = temp;
            temp.next = tempHeadNodeNext;

            temp = tempNext;

            count++;
        }
        int[] arr = new int[count];
        int i = 0;
        while (tempHeadNode.next != null) {
            ListNode next = tempHeadNode.next;
            arr[i++] = next.val;
            tempHeadNode = next;
        }
        return arr;
    }


    /**
     * 使用栈
     */
    public int[] stack(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        while (head != null) {
            stack.add(head.val);
            count++;
            head = head.next;
        }

        int[] ints = new int[count];
        for (int i = 0; !stack.isEmpty(); i++) {
            Integer pop = stack.pop();
            ints[i] = pop;
        }


        return ints;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
