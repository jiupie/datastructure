package jz.carl.tree;

/**
 * @author 南顾北衫
 * @date 2023/5/15
 */
public class _30_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode deleteNode(TreeNode treeNode, int key) {
        if (treeNode == null) {
            return treeNode;
        }

        if (treeNode.val == key) {
            if (treeNode.left == null && treeNode.right == null) {
                //左右都没有
                return null;
            } else if (treeNode.left != null && treeNode.right != null) {
                //左右都有   把删除节点的 左子树 放到删除节点的右子树最左边的节点
                TreeNode temp = treeNode.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = treeNode.left;
                return treeNode.right;
            } else {
                //只有左 或者 右
                TreeNode temp = null;
                if (treeNode.left != null) {
                    temp = treeNode.left;
                } else {
                    temp = treeNode.right;
                }
                return temp;
            }
        }

        if (treeNode.val > key) {
            treeNode.left = deleteNode(treeNode.left, key);
        } else {
            treeNode.right = deleteNode(treeNode.right, key);
        }
        return treeNode;
    }
}
