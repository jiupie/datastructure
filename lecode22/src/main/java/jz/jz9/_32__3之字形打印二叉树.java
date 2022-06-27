package jz.jz9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 这道题的思想就是奇数行正常遍历，偶数行进行从右到左遍历。我们可以设置一个标志位level判断当前行是奇数行还是偶数行，如果是奇数行，那下一行就是偶数行，我们可以将当前节点的子节点从左到右入栈
 * 然后出栈的时候赋给队列就是从右到左；
 * 同理当前行如果是偶数行，说明下一行就是奇数行，那我们将子节点入栈的时候从右到左，出栈时候的顺序就是从左到右
 *
 * @author 南顾北衫
 */
public class _32__3之字形打印二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();


        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        int level = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();

            ArrayDeque<Integer> deque1 = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();

                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
                deque1.add(treeNode.val);
            }

            List<Integer> list1 = new ArrayList<>();
            while (!deque1.isEmpty()) {
                //偶数
                if (level % 2 == 0) {
                    list1.add(deque1.pollLast());
                } else {
                    list1.add(deque1.pollFirst());
                }
            }
            list.add(list1);
            level++;
        }

        return list;
    }
}
