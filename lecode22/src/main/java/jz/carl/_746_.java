package jz.carl;

/**
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * <p>
 * 链接：https://leetcode.cn/problems/min-cost-climbing-stairs
 *
 * @author 南顾北衫
 * @date 2023/4/6
 */
public class _746_ {
    public static void main(String[] args) {

    }

    //1,100,1,1,1,100,1,1,100,1
    //1,100     1
    //1,100,1   2
    //1,100,1,1 2
    //dp[i]= dp[i-1]  dp[i-2]

    //1,100,1,1
    //     1
    //   1   100
    //100 1     1

    //10,15,20
    //  f(20)
    //f(10) f(15)
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1]+ cost[i-1], dp[i-2]+ cost[i-2]) ;
        }

        return dp[cost.length];
    }
}
