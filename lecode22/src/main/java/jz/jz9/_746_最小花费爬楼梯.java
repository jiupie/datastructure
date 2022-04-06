package jz.jz9;

/**
 * @author 南顾北衫
 */
public class _746_最小花费爬楼梯 {
    public static void main(String[] args) {
//        int costs[]={1,100,1,1,1,100,1,1,100,1};
        int costs[] = {10, 15, 20};
        System.out.println(minCostClimbingStairs(costs));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int dp[] = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
