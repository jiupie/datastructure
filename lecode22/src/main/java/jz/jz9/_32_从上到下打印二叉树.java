package jz.jz9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author 南顾北衫
 */
public class _32_从上到下打印二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }

        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
