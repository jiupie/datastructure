package jz.jz9;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author 南顾北衫
 */
public class _27_二叉树的镜像 {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {

        TreeNode temp = root;
        order(temp);
        return root;
    }

    public static void order(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        TreeNode treeNode1 = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = treeNode1;

        order(treeNode.left);
        order(treeNode.right);
    }

}
