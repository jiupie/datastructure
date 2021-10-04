package 链表;

/**
 * _237_删除链表中的节点 class
 *
 * @author 南顾北衫
 * @date 2020/9/8 16:57
 * @email 17674641491@163.com
 */
public class _237_删除链表中的节点 {

    class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
