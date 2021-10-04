package com.wl.link;

import org.junit.Test;

/**
 * DeLinkTest class
 *
 * @author 南顾北衫
 * @date 2020/9/16 18:14
 * @email 17674641491@163.com
 */
public class DeLinkTest {
    @Test
    public void test() {
        DeLink<Integer> deLink = new DeLink<>();
        deLink.add(1);
        deLink.add(2);
        deLink.add(3);
        deLink.add(4);
        deLink.add(5);
        System.out.println(deLink);//{1 2 3 4 5 },size:5
        System.out.println(deLink.indexOf(1));//0
        System.out.println(deLink.contains(1));//true
        System.out.println(deLink.contains(210));//false

        System.out.println(deLink);

        System.out.println(deLink.remove(0));
        System.out.println(deLink);

        System.out.println(deLink.remove(1));
        System.out.println(deLink);
        deLink.add(6);
        deLink.add(7);
        System.out.println("delist添加了6和7后："+deLink);
        System.out.println(deLink.remove(3));
        System.out.println(deLink);

    }
}