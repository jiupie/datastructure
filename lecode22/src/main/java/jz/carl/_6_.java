package jz.carl;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @date 2023/4/17
 */
public class _6_ {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(12);
        for (int i = 0; i < ints[0].length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }

    public static int[][] generateMatrix(int n) {
        int count = 1;
        int[][] ints = new int[n][n];

        int start = 0;
        int end = 0;

        int round = 0;

        int loop = n / 2;
        while (round < loop) {
            //从左到右
            for (; start < n - 1 - round; start++) {
                ints[round][start] = count++;
            }


            //从上到下
            for (; end < n - 1 - round; end++) {
                ints[end][start] = count++;
            }


            //从右到左
            for (; start > round; start--) {
                ints[end][start] = count++;
            }


            //从下到上
            for (; end > round; end--) {
                ints[end][start] = count++;
            }

            round++;
            start = round;
            end = round;
        }
        if (n % 2 == 1) {
            ints[start][start] = count;
        }
        return ints;
    }

}
