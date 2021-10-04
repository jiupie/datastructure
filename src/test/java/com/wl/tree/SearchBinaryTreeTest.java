package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTrees;
import org.junit.Test;

/**
 * SearchBinaryTreeTest class
 *
 * @author 南顾北衫
 * @date 2020/9/21 14:27
 * @email 17674641491@163.com
 */
public class SearchBinaryTreeTest {
    /**
     * put添加
     */
    @Test
    public void put() {
        SearchBinaryTree<Integer, String> binaryTree = new SearchBinaryTree<>();
        binaryTree.put(20, "20");
        binaryTree.put(10, "10");
        binaryTree.put(25, "25");
        binaryTree.put(8, "8");
        binaryTree.put(16, "16");
        binaryTree.put(23, "23");
        binaryTree.put(26, "26");
        binaryTree.put(6, "6");
        binaryTree.put(9, "9");
        binaryTree.put(14, "14");
        binaryTree.put(17, "17");
        binaryTree.put(12, "12");
        BinaryTrees.println(binaryTree);
        System.out.println("二叉查找树元素的个数：" + binaryTree.size());
        System.out.println("获取key=17的Value值：" + binaryTree.get(17));

        binaryTree.delete(12);
        System.out.println("删除12后，元素的个数：" + binaryTree.size());
        BinaryTrees.println(binaryTree);

        System.out.println("最小值：" + binaryTree.getMin().getKey());
        System.out.println("最大值：" + binaryTree.getMax().getKey());
        binaryTree.traversal();
        System.out.println("深度：" + binaryTree.getMaxDepth());

    }

    /**
     * add添加
     */
    @Test
    public void add() {
        //20,10,25,8,16,23,26,6,9,14,17,12
        SearchBinaryTree<Integer, String> binaryTree = new SearchBinaryTree<>();
        binaryTree.add(20, "20");
        binaryTree.add(10, "10");
        binaryTree.add(25, "25");
        binaryTree.add(8, "8");
        binaryTree.add(16, "16");
        binaryTree.add(23, "23");
        binaryTree.add(26, "26");
        binaryTree.add(6, "6");
        binaryTree.add(9, "9");
        binaryTree.add(14, "14");
        binaryTree.add(17, "17");
        binaryTree.add(12, "12");
        BinaryTrees.println(binaryTree);
    }

    /**
     * 先序遍历
     */
    @Test
    public void preOrder() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.println("先序：");
        binaryTree.preOrder();
    }

    public SearchBinaryTree<Integer, String> init() {
        SearchBinaryTree<Integer, String> binaryTree = new SearchBinaryTree<>();
        binaryTree.add(20, "20");
        binaryTree.add(10, "10");
        binaryTree.add(25, "25");
        binaryTree.add(8, "8");
        binaryTree.add(16, "16");
        binaryTree.add(23, "23");
        binaryTree.add(26, "26");
        binaryTree.add(6, "6");
        binaryTree.add(9, "9");
        binaryTree.add(14, "14");
        binaryTree.add(17, "17");
        binaryTree.add(12, "12");
        BinaryTrees.println(binaryTree);
        return binaryTree;
    }

    /**
     * 测试二叉树的高度
     */
    @Test
    public void getMaxDepth() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.println(binaryTree.getMaxDepth());
    }

    /**
     * 层序遍历
     */
    @Test
    public void traversal() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        binaryTree.traversal();
    }


    /**
     * 判断是否为完全二叉树
     */
    @Test
    public void isComplete() {
/*        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.println(binaryTree.isComplete());*/
        SearchBinaryTree<Integer, String> binaryTree = new SearchBinaryTree<>();
        binaryTree.add(7, "20");
        binaryTree.add(4, "10");
        binaryTree.add(9, "25");
        binaryTree.add(2, "8");
        binaryTree.add(1, "16");
        BinaryTrees.println(binaryTree);
        System.out.println(binaryTree.isComplete());
    }

    /**
     * 翻转二叉树
     */
    @Test
    public void reserveTree() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        binaryTree.reserveTree();
        BinaryTrees.println(binaryTree);
    }


    /**
     * 复制二叉树
     */
    @Test
    public void copyTree() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        SearchBinaryTree<Integer, String> node = binaryTree.copyTree();
        BinaryTrees.println(binaryTree);
    }

    /**
     * 查找父节点，迭代方式寻找
     */
    @Test
    public void foundParentIteration() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.println(binaryTree.getRoot().getKey());
        System.out.println(binaryTree.foundParentIteration(binaryTree.getRoot()).getKey());
    }

    /**
     * 查找父节点，递归方式寻找
     */
    @Test
    public void foundParent() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.println(binaryTree.getRoot().left.right.left.left.getKey());
        System.out.println(binaryTree.foundParent(binaryTree.getRoot().left.right.left.left).getKey());
    }

    /**
     * 前驱节点
     */
    @Test
    public void predecessor() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.print("中序：");
        binaryTree.inOrder();
        System.out.println();

        System.out.println("12的前驱节点：" + binaryTree.predecessor(binaryTree.getRoot().left.right.left.left).getKey());
        System.out.println("20的前驱节点：" + binaryTree.predecessor(binaryTree.getRoot()).getKey());
        System.out.println("6的前驱节点：" + binaryTree.predecessor(binaryTree.getRoot().left.left.left).getKey());
    }

    /**
     * 后继节点
     */
    @Test
    public void successor() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.print("中序：");
        binaryTree.inOrder();
        System.out.println();

        System.out.println("12的后继节点：" + binaryTree.successor(binaryTree.getRoot().left.right.left.left).getKey());
        System.out.println("20的后继节点：" + binaryTree.successor(binaryTree.getRoot()).getKey());
        System.out.println("6的后继节点：" + binaryTree.successor(binaryTree.getRoot().left.left.left).getKey());
    }

    @Test
    public void getNode() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        System.out.println(binaryTree.getNode(12).getKey());

    }

    @Test
    public void remove() {
        SearchBinaryTree<Integer, String> binaryTree = init();
        binaryTree.remove(12);
        BinaryTrees.println(binaryTree);
        binaryTree.remove(20);
        BinaryTrees.println(binaryTree);
        binaryTree.remove(16);
        BinaryTrees.println(binaryTree);
    }


}