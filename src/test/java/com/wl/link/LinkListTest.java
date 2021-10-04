package com.wl.link;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * LinkListTest class
 *
 * @author 南顾北衫
 * @date 2020/9/15 21:51
 * @email 17674641491@163.com
 */
public class LinkListTest {
    @Test
    public void test() {
        LinkList<Integer> list = new LinkList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
        list.remove(1);

        System.out.println(list);
    }

}