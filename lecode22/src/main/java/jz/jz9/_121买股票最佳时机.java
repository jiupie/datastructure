package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/4/1
 */
public class _121买股票最佳时机 {
    public static void main(String[] args) {
        int[] ints = {2, 4, 1};
//        int[] ints = {7, 1, 5, 3, 6, 4};
//        int[] ints = {7, 6, 4, 3, 1};
        System.out.println(maxProfit2(ints));
    }

    /**
     * 循环
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int num = prices[j] - prices[i];
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int low = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            max = Math.max(prices[i] - low, max);
        }

        return max;
    }
}
