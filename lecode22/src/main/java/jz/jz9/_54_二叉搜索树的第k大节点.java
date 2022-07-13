package jz.jz9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南顾北衫
 */
public class _54_二叉搜索树的第k大节点 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(1);

        root.left = treeNode1;
        root.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode3.left = treeNode5;
        System.out.println(kthLargest(root, 3));
    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        order(root, list, 3);
        return list.get(k - 1);
    }


    public static void order(TreeNode treeNode, List<Integer> list, int k) {
        if (treeNode == null) {
            return;
        }
        order(treeNode.right, list, k);
        list.add(treeNode.val);
        order(treeNode.left, list, k);
    }
}
