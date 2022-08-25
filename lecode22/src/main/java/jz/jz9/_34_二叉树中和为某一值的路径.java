package jz.jz9;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 南顾北衫
 */
public class _34_二叉树中和为某一值的路径 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (target == root.val) {
            res.add(list1);
            return res;
        }
        leave = target - root.val;
        list1.add(root.val);
        list2.add(root.val);

        order(root.left, list1, target);

        leave = target - root.val;
        order(root.right, list2, target);

        if (list1.size() != 0) {
            res.add(list1);
        }

        if (list2.size() != 0) {
            res.add(list2);
        }
        return res;
    }

    private int leave;

    public void order(TreeNode node, List<Integer> list, int target) {
        if (node == null) {
            return;
        }
        order(node.left, list, target);
        if (leave > node.val) {
            list.add(node.val);
            leave = leave - node.val;
        }
        order(node.right, list, target);
    }
}
