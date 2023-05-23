package jz.carl.tree;

import java.util.ArrayList;

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

    //中序 左中右
    //后序 左右中
    TreeNode d(int[] inorder, int[] postorder, int b1, int end1, int begin, int end) {
        if (end - begin <= 0) {
            return null;
        }

        int i = postorder[end - 1];

        TreeNode node = new TreeNode(i);

        if (begin - end == 1) {
            return node;
        }

        int index = -1;
        for (int j = b1; j < end1; j++) {
            if (inorder[j] == i) {
                index = j;
                break;
            }
        }


        node.left = d(inorder, postorder, b1, index, begin, begin + index - b1);
        node.right = d(inorder, postorder, index + 1, end1, begin + index - b1, end - 1);

        return node;
    }
}
