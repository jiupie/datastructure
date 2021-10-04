package com.wl.link;


import org.junit.Test;

/**
 * LinkListCircleTest class
 *
 * @author 南顾北衫
 * @date 2020/9/16 21:08
 * @email 17674641491@163.com
 */
public class LinkListCircleTest {
    @Test
    public void test() {
        LinkListCircle<Integer> list = new LinkListCircle<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);
        list.add(4,5);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }

}