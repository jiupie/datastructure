package com.wl.practice.josephs;


/**
 * Josephs class
 * 约瑟夫问题
 * 利用双向循环链表解决
 *
 * @author 南顾北衫
 * @date 2020/9/17 22:20
 * @email 17674641491@163.com
 */
public class Josephs {
    public static void main(String[] args) {
        DeLinkCircle<Integer> objectDeLinkCircle = new DeLinkCircle<>();
        for (int i = 1; i <= 8; i++) {
            objectDeLinkCircle.add(i);
        }//[size=8, 8_1_2, 1_2_3, 2_3_4, 3_4_5, 4_5_6, 5_6_7, 6_7_8, 7_8_1]
        objectDeLinkCircle.reset();
        while (objectDeLinkCircle.curr != null) {
            objectDeLinkCircle.next();
            objectDeLinkCircle.next();
            System.out.println(objectDeLinkCircle.remove());
        }
        //[size=7, 8_1_2, 1_2_3, 3_4_5, 4_5_6,             5_6_7,        6_7_8, 7_8_1] indexof 4
        //[size=8, 8_1_2, 1_2_3, 2_3_4, 3_4_5, 4_5_6, 5_6_7, 6_7_8, 7_8_1]


    }
}
