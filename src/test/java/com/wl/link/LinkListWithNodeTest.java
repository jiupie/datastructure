package com.wl.link;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * LinkListWithNodeTest class
 *
 * @author 南顾北衫
 * @date 2020/9/15 21:29
 * @email 17674641491@163.com
 */
public class LinkListWithNodeTest   {
    @Test
    public void test() {
        LinkListWithNode<Integer> listWithNode = new LinkListWithNode<>();
        listWithNode.add(1);
        listWithNode.add(2);
        listWithNode.add(3);
        listWithNode.add(4);
        listWithNode.add(5);
        listWithNode.add(6);
        System.out.println(listWithNode);
        listWithNode.remove(0);
        System.out.println(listWithNode);
    }

}