package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/16
 */
public class _33_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode convertBST(TreeNode root) {

        recursion(root);
        return root;
    }

    int pre = 0;

    //右中左
    public void recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        recursion(root.right);

        root.val += pre;
        pre = root.val;

        recursion(root.left);
    }

}
