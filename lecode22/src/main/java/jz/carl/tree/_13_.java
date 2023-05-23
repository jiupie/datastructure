package jz.carl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/5/9
 */
public class _13_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<Integer> list = new ArrayList<>();
    private List<String> resList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        d(root);
        return resList;
    }

    public void d(TreeNode root) {
        int val = root.val;
        list.add(val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (list.size() - 1 != i) {
                    stringBuilder.append("->");
                }
            }
            resList.add(stringBuilder.toString());
        }

        if (root.left != null) {
            d(root.left);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            d(root.right);
            list.remove(list.size() - 1);
        }
    }
}
