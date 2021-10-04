package com.wl.algorithmstrategy.recursion;

/**
 * 斐波拉契数列
 * 斐波那契数列：1、1、2、3、5、8、13、21、34、……
 * <p>
 * F ( 1 ) = 1 ， F ( 2 ) = 1 ， F ( n ) = F ( n − 1 ) + F ( n − 2 ) （ n ≥ 3 ）
 * <p>
 * F(1)=1，F(2)=1，F(n)=F(n−1)+F(n−2)（n≥3）
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Fib {
    public static void main(String[] args) {

        System.out.println(fib(20));
        System.out.println(fib1(20));
        System.out.println(fib3(20));
        System.out.println(fib4(20));


    }

    /**
     * 递归
     *
     * @param n
     */
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 优化1：递归
     * 记忆化
     * 加上一个数组存储重复计算的子问题
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        int[] ints = new int[n + 1];
        ints[1] = ints[2] = 1;
        return fib2(n, ints);
    }

    public static int fib2(int n, int[] arr) {
        if (arr[n] == 0) {
            return fib(n - 1) + fib(n - 2);
        }
        return arr[n];
    }

    /**
     * 优化2：去递归
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        int[] ints = new int[n + 1];
        ints[1] = ints[2] = 1;
        for (int i = 3; i < ints.length; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    /**
     * 优化3：滚动数组
     *
     * @param n
     * @return
     */
    public static int fib4(int n) {
        int[] temp = new int[2];
        temp[0] = temp[1] = 1;
        for (int i = 3; i <=n; i++) {
            temp[i % 2] = temp[(i - 1) % 2] + temp[(i-2)% 2];
        }
        return temp[n % 2];
    }


}
