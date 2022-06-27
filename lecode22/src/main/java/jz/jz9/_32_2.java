package jz.jz9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 南顾北衫
 */
public class _32_2 {
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
