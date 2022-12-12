package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/7/10
 */
public class _55_II_平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);

        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode3.left = treeNode5;
        treeNode4.right = treeNode6;

        System.out.println(isBalanced(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int blance = blance(root.left, 0);
        int blance1 = blance(root.right, 0);
        if (Math.abs(blance - blance1) > 1) {
            return false;
        } else {
            boolean balanced = isBalanced(root.left);
            boolean balanced1 = isBalanced(root.right);
            if (!balanced || !balanced1) {
                return false;
            }
        }
        return true;
    }

    public static int blance(TreeNode root, int height) {
        if (root == null) {
            return height;
        } else {
            height++;
        }

        return Math.max(blance(root.left, height), blance(root.right, height));

    }

}
