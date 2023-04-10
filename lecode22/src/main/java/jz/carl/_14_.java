package jz.carl;

/**
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>
 * 0-1背包：物品  容量
 * 链接：https://leetcode.cn/problems/last-stone-weight-ii
 *
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class _14_ {
    public static void main(String[] args) {
        _14_ v = new _14_();
        //[2,7,4,1,8,1]
        //[14,1,7,17,8,10]
        int[] a = {14, 1, 7, 17, 8, 10};
        System.out.println(v.lastStoneWeightII(a));
    }

    //stones = [2,7,4,1,8,1]
    public int lastStoneWeightII(int[] stones) {
        int sum = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum >> 1;

        int[][] dp = new int[stones.length][target + 1];

        for (int i = stones[0]; i <= target; i++) {
            dp[0][i] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (stones[i] <= j) {
                    //选 or 不选
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[stones.length - 1][target];
    }
}
