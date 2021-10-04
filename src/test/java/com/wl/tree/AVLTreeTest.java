package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTrees;
import org.junit.Test;

/**
 * AVLTreeTest class
 *
 * @author 南顾北衫
 * @date 2020/9/24 12:33
 * @email 17674641491@163.com
 */
public class AVLTreeTest {

    public AVLTree<Integer> init() {
        //13，14，15，12，11，17，16，8，9，1,18,2,3,6,20
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(13);
        avlTree.add(14);
        avlTree.add(15);
        avlTree.add(12);
        avlTree.add(11);
        avlTree.add(17);
        avlTree.add(16);
        avlTree.add(8);
        avlTree.add(9);
        avlTree.add(1);
        avlTree.add(18);
        avlTree.add(2);
        avlTree.add(3);
        avlTree.add(6);
        avlTree.add(20);
        return avlTree;
    }

    @Test
    public void add() {
        AVLTree<Integer> avlTree = init();
        BinaryTrees.println(avlTree);
    }

    @Test
    public void remove() {
       AVLTree<Integer> avlTree = new AVLTree<>();
       Integer []data=new Integer[]{
               85,19,69,3,7,99,95
       };
        for (int i = 0; i < data.length; i++) {
            avlTree.add(data[i]);
        }
        BinaryTrees.println(avlTree);

        avlTree.remove(99);
        BinaryTrees.println(avlTree);

        avlTree.remove(85);
        BinaryTrees.println(avlTree);

    }
}