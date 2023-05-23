package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/16
 */
public class _31_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }


        TreeNode left = null;
        if (root.left != null) {
            left = trimBST(root.left, low, high);
        }

        TreeNode right = null;
        if (root.right != null) {
            right = trimBST(root.right, low, high);
        }
        //null 2

        if (root.val < low || root.val > high) {
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            if (left == null && right == null) {
                return null;
            }
        }


        root.left = left;
        root.right = right;
        return root;
    }
}
