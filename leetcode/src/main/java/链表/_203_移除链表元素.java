package 链表;

/**
 * _203_移除链表元素 class
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author 南顾北衫
 * @date 2020/9/11 10:37
 * @email 17674641491@163.com
 */
public class _203_移除链表元素 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode headNode = new ListNode(0);
            headNode.next = head;
            ListNode cur = head;
            ListNode pre = head;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
            }
            return headNode.next;
        }
    }
}
