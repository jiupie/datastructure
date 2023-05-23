package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/15
 */
public class _29_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode cur = root;
        TreeNode parent = cur;
        while (cur != null) {
            if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        if (parent.val > val) {
            parent.left = new TreeNode(val);
        }
        if (parent.val < val) {
            parent.right = new TreeNode(val);
        }
        return root;
    }


}
