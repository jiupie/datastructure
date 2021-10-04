package com.wl.tree;

/**
 * ThreadBinaryTreeDemo class
 * 线索化二叉树创建、遍历
 *
 * @author 南顾北衫
 * @date 2020/6/3 17:50
 * @email 17674641491@163.com
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {
        ThreadTreeNode treeNode1 = new ThreadTreeNode(1);
        ThreadTreeNode treeNode2 = new ThreadTreeNode(2);
        ThreadTreeNode treeNode3 = new ThreadTreeNode(3);
        ThreadTreeNode treeNode4 = new ThreadTreeNode(4);
        ThreadTreeNode treeNode5 = new ThreadTreeNode(5);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        ThreadTreeNode threadTreeNode = new ThreadTreeNode();
        threadTreeNode.createThreadTree(treeNode1);
       /* System.out.println(treeNode4.getRight());
        System.out.println(treeNode3.getLeft());
        System.out.println(treeNode2.getLeft());*/
        threadTreeNode.iniOrder(treeNode1);
    }
}

class ThreadTreeNode {
    private int num;
    public ThreadTreeNode left;
    public ThreadTreeNode right;
    public int leftNodeType;
    public int rightNodeType;

    public ThreadTreeNode(int num) {
        this.num = num;
    }

    ThreadTreeNode pre = null;

    public void preOrder(ThreadTreeNode node) {
        while (node != null) {
            System.out.println(node.getNum());
            while (node.leftNodeType==0){
                node=node.getLeft();
            }
            while (node.getRightNodeType()==1){
                node=node.getRight();
                System.out.println(node.getNum());
            }
            node=node.getRight();
        }
    }
    public void iniOrder(ThreadTreeNode node) {
        while (node != null) {
            while (node.leftNodeType==0){
                node=node.getLeft();
            }
            System.out.println(node.getNum());
            while (node.getRightNodeType()==1){
                node=node.getRight();
                System.out.println(node.getNum());
            }
            node=node.getRight();
        }
    }
    public void createThreadTree(ThreadTreeNode root) {
        if (root == null) {
            return;
        }
        createThreadTree(root.left);
        if (root.left == null) {
            root.left = pre;
            root.leftNodeType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = root;
            pre.rightNodeType = 1;
        }
        pre = root;
        createThreadTree(root.right);
    }

    public ThreadTreeNode() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ThreadTreeNode{" +
                "num=" + num +
                ",leftNodeType=" + leftNodeType +
                ",rightNodeType=" + rightNodeType +
                '}';
    }

    public ThreadTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadTreeNode left) {
        this.left = left;
    }

    public ThreadTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadTreeNode right) {
        this.right = right;
    }

    public int getLeftNodeType() {
        return leftNodeType;
    }

    public void setLeftNodeType(int leftNodeType) {
        this.leftNodeType = leftNodeType;
    }

    public int getRightNodeType() {
        return rightNodeType;
    }

    public void setRightNodeType(int rightNodeType) {
        this.rightNodeType = rightNodeType;
    }
}

