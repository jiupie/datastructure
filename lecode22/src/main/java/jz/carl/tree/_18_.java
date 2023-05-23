package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/11
 */
public class _18_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        _18_ v = new _18_();

        v.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return d(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    public TreeNode d(int[] inorder, int[] postorder, int b1, int e1, int b2, int e2) {
        if (e2 - b2 <= 0) {
            return null;
        }

        int i = postorder[e2 - 1];

        TreeNode treeNode = new TreeNode(i);
        if (e2 - b2 == 1) {
            return treeNode;
        }
        int index = -1;
        for (int j = b1; j < e1; j++) {
            if (inorder[j] == i) {
                index = j;
                break;
            }
        }

        //分割
        treeNode.left = d(inorder, postorder, b1, b1 + index, b2, b2 + index - b1);
        treeNode.right = d(inorder, postorder, b1 + index + 1, e1, b2 + index - b1, e2 - 1);

        return treeNode;
    }
}
