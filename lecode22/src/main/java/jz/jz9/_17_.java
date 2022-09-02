package jz.jz9;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @date 2022/9/2
 */
public class _17_ {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(3)));
    }


    public static int[] printNumbers(int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum = sum * 10;
        }
        sum -= 1;
        int[] ints = new int[sum];
        for (int j = 0; j < sum; j++) {
            ints[j] = j + 1;
        }
        return ints;
    }


    public static String printNumbers1(int n) {

        return "";
    }
}
