package com.wl.algorithmstrategy.greed;

import java.util.Arrays;

/**
 * 贪心策略-零钱兑换
 * <p>
 * 假设有25分、10分、5分、1分的硬币，现在要找客户41分零钱，如何办到硬币个数最少？
 * <p>
 * 贪心策略：每一次选择面值最大的硬币
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class Coins {
    public static void main(String[] args) {
        test2();

    }

    /**
     * 一枚硬币只用了一次
     */
    public static void test1() {
        Integer[] faceCoins = {25, 10, 1, 5};
        int money = 41;
        Arrays.sort(faceCoins, (o1, o2) -> o2 - o1);
        for (int i = 0; i < faceCoins.length; i++) {
            if (money - faceCoins[i] >= 0) {
                money -= faceCoins[i];
                System.out.println(faceCoins[i]);
            }
        }
    }

    /**
     * 重复选择硬币
     */
    public static void test2() {
//        Integer[] faceCoins = {25, 10, 1, 5};
        Integer[] faceCoins = {25, 20, 1, 5};
        int money = 41;
        Arrays.sort(faceCoins, (o1, o2) -> o2 - o1);
        for (int i = 0; i < faceCoins.length; i++) {
            if (money - faceCoins[i] >= 0) {
                money -= faceCoins[i];
                System.out.println(faceCoins[i]);
                i--;
            }
        }
    }
}
