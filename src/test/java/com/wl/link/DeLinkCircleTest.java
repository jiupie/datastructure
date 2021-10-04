package com.wl.link;

import org.junit.Test;

/**
 * DeLinkCircleTest class
 *
 * @author 南顾北衫
 * @date 2020/9/17 20:12
 * @email 17674641491@163.com
 */
public class DeLinkCircleTest {
    @Test
    public void test() {
        DeLinkCircle<Integer> list = new DeLinkCircle<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(4, 5);
        System.out.println(list);
        list.add(0, 6);//5_6_1,6_1_2, 1_2_3, 2_3_4, 3_4_5, 4_5_6
        System.out.println(list);

        list.remove(0);//5_1_2, 1_2_3, 2_3_4, 3_4_5, 4_5_1
        System.out.println(list);
        list.remove(5);// 4_1_2, 1_2_3, 2_3_4, 3_4_1
        System.out.println(list);
        list.remove(1);// 4_1_3,1_3_4, 3_4_1
        System.out.println(list);
        list.remove(0);// 1_3_4, 3_4_1
        System.out.println(list);
        list.remove(0);//  3_4_1
        System.out.println(list);
        list.remove(0);//
        System.out.println(list);

    }
}