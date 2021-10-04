package com.wl.union;

import com.wl.union.untils.Times;
import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQU_SizeTest {
    public static int count = 100000;

    @Test
    public void union() {
        // testTime(new UnionFind_QF(count)); // 太慢,不测
        // testTime(new UnionFind_QU(count)); // 太慢,不测

//        testTime(new UnionFindQF(count));
//        testTime(new UnionFindQU(count));
//        testTime(new UnionFindQU_Rank(count));
//        testTime(new UnionFindQU_Size(count));
        UnionFindQU_Size unionFindQUSize = new UnionFindQU_Size(4);
        unionFindQUSize.union(1,0);
        unionFindQUSize.union(0,2);
        System.out.println(unionFindQUSize.isSame(1, 3));

        unionFindQUSize.union(2,3);
        System.out.println(unionFindQUSize.isSame(1, 3));
        System.out.println(unionFindQUSize.isSame(1, 2));
        System.out.println(unionFindQUSize.isSame(3, 2));
        System.out.println(unionFindQUSize.isSame(3, 0));


    }

    static void testTime(UnionFind uf) {
        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int) (Math.random() * count),
                        (int) (Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int) (Math.random() * count),
                        (int) (Math.random() * count));
            }
        });
    }

}