package jz.carl;

/**
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 *
 * @author 南顾北衫
 * @date 2023/4/6
 */
public class _70_ {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
