package jz.jz9;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @author 南顾北衫
 */
public class _28_对称的二叉树 {

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

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
       return iseq(root.left, root.right);
    }

    public boolean iseq(TreeNode l, TreeNode r) {

        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null) {
            return false;
        }

        if (l.val != r.val) {
            return false;
        }

        if (!iseq(l.left, r.right)) {
            return false;
        }

        if (!iseq(l.right, r.left)) {
            return false;
        }
        return true;
    }

}


