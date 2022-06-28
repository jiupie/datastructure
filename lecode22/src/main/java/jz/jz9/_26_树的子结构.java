package jz.jz9;

import java.util.ArrayList;
import java.util.List;

/**
 * 因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * @author 南顾北衫
 */
public class _26_树的子结构 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);


        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(4);
        treeNode5.right = treeNode6;

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.right = treeNode4;

        System.out.println(isSubStructure(treeNode, treeNode5));

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        search(A, B.val, list);

        if (list.isEmpty()) {
            return false;
        }
        for (TreeNode treeNode : list) {
            if (isSub(treeNode, B)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isSub(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }


        if (a.val != b.val) {
            return false;
        }

        if (!isSub(a.left, b.left)) {
            return false;
        }

        return isSub(a.right, b.right);
    }

    public static void search(TreeNode treeNode, int val, List<TreeNode> resList) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val == val) {
            resList.add(treeNode);

        }
        search(treeNode.left, val, resList);

        search(treeNode.right, val, resList);
    }

}
