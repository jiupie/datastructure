package com.wl.union;

import com.wl.union.untils.Times;
import org.junit.Test;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UnionFindQU_Rank_PathCompressionTest {
    public static int count = 200000;

    @Test
    public void test() {
        UnionFindQU_Rank_PathCompression unionFindQU_rank_pathCompression = new UnionFindQU_Rank_PathCompression(4);
        unionFindQU_rank_pathCompression.union(1, 0);
        unionFindQU_rank_pathCompression.union(0, 2);
        System.out.println(unionFindQU_rank_pathCompression.isSame(1, 3));

        unionFindQU_rank_pathCompression.union(2, 3);
        System.out.println(unionFindQU_rank_pathCompression.isSame(1, 3));
        System.out.println(unionFindQU_rank_pathCompression.isSame(1, 2));
        System.out.println(unionFindQU_rank_pathCompression.isSame(3, 2));
        System.out.println(unionFindQU_rank_pathCompression.isSame(3, 0));
        UnionFindQU_Rank_PathCompression u1 = new UnionFindQU_Rank_PathCompression(count);
        testTime(u1);
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