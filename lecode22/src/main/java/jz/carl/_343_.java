package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/7
 */
public class _343_ {
    public static void main(String[] args) {
        _343_ v = new _343_();
        System.out.println(v.integerBreak(8));
        System.out.println(v.integerBreak1(8));
        System.out.println(v.integerBreak2(8));
    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }

        return dp[n];
    }


    public int integerBreak1(int n) {
        if (n == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max((n - i) * i, Math.max(integerBreak1(n - i) *i, res));
        }
        return res;
    }

    public int integerBreak2(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max((i - j) * j, Math.max(dp[i], dp[i - j] * j));
            }
        }
        return dp[n];
    }


}
