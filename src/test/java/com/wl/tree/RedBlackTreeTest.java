package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTrees;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RedBlackTreeTest class
 *
 * @author 南顾北衫
 * @date 2020/10/6 16:35
 * @email 17674641491@163.com
 */
public class RedBlackTreeTest {
    public RedBlackTree<Integer> init() {
        //13，14，15，12，11，17，16，8，9，1,18,2,3,6,20
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        rbTree.add(13);
        rbTree.add(14);
        rbTree.add(15);
        rbTree.add(12);
        rbTree.add(11);
        rbTree.add(17);
        rbTree.add(16);
        rbTree.add(8);
        rbTree.add(9);
        rbTree.add(1);
        rbTree.add(18);
        rbTree.add(2);
        rbTree.add(3);
        rbTree.add(6);
        rbTree.add(20);
        return rbTree;
    }

    @Test
    public void test() {
        RedBlackTree<Integer> init = init();
        BinaryTrees.println(init);
    }

}