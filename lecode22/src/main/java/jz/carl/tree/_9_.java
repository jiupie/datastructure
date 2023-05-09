package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/8
 */
public class _9_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left) + 1;
        int i1 = maxDepth(root.right) + 1;
        return Math.max(i, i1);

    }
}
