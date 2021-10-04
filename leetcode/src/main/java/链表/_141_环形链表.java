package 链表;

/**
 * _141_环形链表 class
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author 南顾北衫
 * @date 2020/9/9 16:39
 * @email 17674641491@163.com
 */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
