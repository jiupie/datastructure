package com.wl.union;

import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQUTest {
    @Test
    public void union() {
        UnionFindQU unionFindQU = new UnionFindQU(5);
        unionFindQU.union(1, 0);
        unionFindQU.union(1, 2);
        unionFindQU.union(3, 4);
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "=" + unionFindQU.find(i));
        }
        System.out.println("==========================");

        System.out.println(unionFindQU.isSame(3, 4));//true
        System.out.println(unionFindQU.isSame(0, 4));//false
        System.out.println(unionFindQU.isSame(0, 2));//true
        System.out.println(unionFindQU.isSame(0, 1));//true

    }

}