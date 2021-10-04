package 动态规划;

import java.util.Arrays;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int m[] = {7, 1, 5, 3, 6, 4};

    }

    public int maxProfit(int[] prices) {
        int[] temp = new int[prices.length];

        temp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            int i1 = prices[i - 1] - prices[i];
            temp[i] = i1;
        }

        return 0;
    }
}
