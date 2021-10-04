package com.wl.union;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.PreparedStatement;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQFTest {
    @Test
    public void unionFind(){
        UnionFindQF unionFindQF = new UnionFindQF(5);
        unionFindQF.union(1, 0);
        unionFindQF.union(1, 2);
        unionFindQF.union(3, 4);
//        unionFindQF.union(0, 3);
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "=" + unionFindQF.find(i));
        }
        System.out.println("==========================");
        System.out.println(unionFindQF.isSame(3, 4));//true
        System.out.println(unionFindQF.isSame(0, 4));//false
        System.out.println(unionFindQF.isSame(0, 2));//true
        System.out.println(unionFindQF.isSame(0, 1));//true
    }

}