package 链表;

/**
 * _206_反转链表_递归 class
 *https://leetcode-cn.com/problems/reverse-linked-list/
 * @author 南顾北衫
 * @date 2020/9/8 17:07
 * @email 17674641491@163.com
 */
public class _206_反转链表_迭代 {


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
            }
            return newHead;
        }
    }
}
