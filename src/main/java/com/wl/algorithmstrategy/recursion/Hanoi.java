package com.wl.algorithmstrategy.recursion;

/**
 * 汉罗塔问题
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(100,"A","B","C");
    }

    /**
     * @param n  盘子编号
     * @param p1
     * @param p2
     * @param p3
     */
    public static void hanoi(int n, String p1, String p2, String p3) {
        if (n == 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n-1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n-1, p3, p2, p1);

    }

    public static void move(int n, String from, String to) {
        System.out.println("编号" + n + ":从" + from + "移动到" + to);
    }
}
