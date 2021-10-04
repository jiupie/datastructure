package com.wl.tree;

import java.beans.Introspector;

/**
 * BinaryTreeDemo class
 * 二叉树遍历 删除 查找
 *
 * @author 南顾北衫
 * @date 2020/6/2 17:06
 * @email 17674641491@163.com
 */
public class BinaryTreeDemo {
    /**
     * 先序
     *
     * @param node
     */
    public static void preOrder(TreeNode node) {
        System.out.println(node.getNum());
        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    /**
     * 中序
     *
     * @param node
     */
    public static void inifOrder(TreeNode node) {
        TreeNode nodeLeft = node.getLeft();
        TreeNode nodeRight = node.getRight();
        if (nodeLeft != null) {
            inifOrder(nodeLeft);
        }
        System.out.println(node.getNum());
        if (nodeRight != null) {
            inifOrder(nodeRight);
        }
    }

    public static void postOrder(TreeNode node) {
        TreeNode nodeLeft = node.getLeft();
        TreeNode nodeRight = node.getRight();
        if (nodeLeft != null) {
            postOrder(nodeLeft);
        }
        if (nodeRight != null) {
            postOrder(nodeRight);
        }
        System.out.println(node.getNum());
    }

    public static void preSearch(TreeNode node, int num) {
        if (node.getNum() == num) {
            System.out.println(node.getNum() + "===" + node.toString());
            return;
        }
        if (node.getLeft() != null) {
            preSearch(node.getLeft(), num);
        }
        if (node.getRight() != null) {
            preSearch(node.getRight(), num);
        }
    }

    /**
     * 如果要删除的节点是叶子节点就直接删除
     * 如果不是叶子节点就删除子树
     */
    public static void deleteNode(TreeNode node, int num) {
        TreeNode nodeLeft = node.getLeft();
        TreeNode nodeRight = node.getRight();
        if (node != null) {
            if (nodeLeft != null && nodeLeft.getNum() == num) {
                System.out.println("delete:" + nodeLeft.getNum() + "===" + nodeLeft.toString());
                node.left = null;
                return;
            }
            if (nodeRight != null && nodeRight.getNum() == num) {
                System.out.println("delete:" + nodeRight.getNum() + "===" + nodeRight.toString());
                node.right = null;
                return;
            }
            if (nodeLeft != null) {
                deleteNode(nodeLeft, num);
            }
            if (nodeRight != null) {
                deleteNode(nodeRight, num);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
       /*
        preOrder(treeNode1);
        System.out.println("=====================");
        inifOrder(treeNode1);
        System.out.println("=====================");
        postOrder(treeNode1);
        System.out.println("=====================");
        preSearch(treeNode1, 2);
         */

        deleteNode(treeNode1, 2);
        System.out.println("=====================");
        inifOrder(treeNode1);
    }


}

class TreeNode {
    private int num;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "num=" + num +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode() {
    }

    public TreeNode(int num) {
        this.num = num;
    }

    public TreeNode(int num, TreeNode left, TreeNode right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
