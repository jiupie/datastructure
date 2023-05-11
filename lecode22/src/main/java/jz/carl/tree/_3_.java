package jz.carl.tree;

import java.util.*;

/**
 * @author 南顾北衫
 * @date 2023/5/4
 */
public class _3_ {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right = treeNode1;
        treeNode1.left = treeNode2;

        _3_ v = new _3_();
        v.forEachOrder(treeNode);
        v.forEachPost(treeNode);


    }

    //迭代遍历 先序：中左右
    public void forEachPre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    //迭代遍历 中序：左中右
    public void forEachOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                cur = pop.right;
            }
        }
    }

    //后序
    public void forEachPost(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            list.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }

            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        Collections.reverse(list);

        System.out.println(list);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resList = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
