package com.wl.union;

import com.wl.union.untils.Times;
import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQU_RankTest {
    public static int count = 100000;

    @Test
    public void test() {
        UnionFindQU_Rank unionFindQURank = new UnionFindQU_Rank(4);
        unionFindQURank.union(1,0);
        unionFindQURank.union(0,2);
        System.out.println(unionFindQURank.isSame(1, 3));

        unionFindQURank.union(2,3);
        System.out.println(unionFindQURank.isSame(1, 3));
        System.out.println(unionFindQURank.isSame(1, 2));
        System.out.println(unionFindQURank.isSame(3, 2));
        System.out.println(unionFindQURank.isSame(3, 0));
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