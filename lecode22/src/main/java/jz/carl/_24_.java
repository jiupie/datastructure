package jz.carl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/4/12
 */
public class _24_ {
    public static void main(String[] args) {
        _24_ v = new _24_();
        System.out.println(v.numSquares(12));
        System.out.println(v.numSquares(1));
    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.pow(i, 2);
            if (sqrt > n) {
                break;
            }
            list.add(sqrt);
        }


        Integer[] integers = list.toArray(new Integer[0]);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < integers.length; i++) {
            for (int j = integers[i]; j <= n; j++) {
                if (dp[j - integers[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - integers[i]] + 1);
                }
            }
        }

        return dp[n];
    }
}
