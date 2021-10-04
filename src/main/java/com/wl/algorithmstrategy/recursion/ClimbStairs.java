package com.wl.algorithmstrategy.recursion;

/**
 * 上楼梯（跳台阶）
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climb(2));

    }

    public static int climb(int n) {
        if (n <= 2) {
            return n;
        }
        return climb(n - 1) + climb(n - 2);
    }
}
