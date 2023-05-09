package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/8
 */
public class _10_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i1 = minDepth(root.left);
        int i2 = minDepth(root.right);
        if (root.left != null && root.right == null) {
            return i1 + 1;
        }
        if (root.left == null && root.right != null) {
            return i2 + 1;
        }
        return Math.min(i1, i2) + 1;
    }


}
