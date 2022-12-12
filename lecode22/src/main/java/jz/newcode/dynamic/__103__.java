package jz.newcode.dynamic;

public class __103__ {
//      //dp[0]=0
//        dp[1]=1
//            1+dp[0]
//
//        dp[2]=1
//          min
//            1+dp[1]=2
//            2+dp[0]=1
//
//        dp[3]=2
//            1+dp[2]=2
//            2+dp[2]=2
//
//        dp[4]=2
//            1+dp[3]=3
//            2+dp[2]=2
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i <= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                } else {
                    break;
                }
            }
        }

        return dp[amount];
    }
}
