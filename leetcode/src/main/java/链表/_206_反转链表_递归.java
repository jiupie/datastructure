package 链表;

/**
 * _206_反转链表_递归 class
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author 南顾北衫
 * @date 2020/9/8 17:07
 * @email 17674641491@163.com
 */
public class _206_反转链表_递归 {


    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
