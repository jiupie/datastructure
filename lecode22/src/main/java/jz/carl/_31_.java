package jz.carl;

import java.util.*;

/**
 * @author 南顾北衫
 * @date 2023/4/13
 */
public class _31_ {
    public static class TreeNode {
        int val;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TreeNode)) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {
        return deepth(root);
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    private int deepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        Integer integer = map.get(node);
        if (integer != null) {
            return integer;
        }
        //爷节点
        int value1 = node.val;

        //孙子
        if (node.left != null) {
            value1 += deepth(node.left.left);
            value1 += deepth(node.left.right);
        }

        //孙子
        if (node.right != null) {
            value1 += deepth(node.right.left);
            value1 += deepth(node.right.right);
        }

        int value2 = 0;
        value2 += deepth(node.left);
        value2 += deepth(node.right);
        int max = Math.max(value1, value2);
        map.put(node, max);
        return max;
    }

}
