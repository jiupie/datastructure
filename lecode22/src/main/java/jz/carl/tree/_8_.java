package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/8
 */
public class _8_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        d(root.left, root.right);
        return s;
    }

    boolean s = true;

    void d(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }

        if (left == null || right == null) {
            s = false;
            return;
        }

        if (left.val != right.val) {
            s = false;
            return;
        }
        d(left.left, right.right);
        d(left.right, right.left);
    }

}
