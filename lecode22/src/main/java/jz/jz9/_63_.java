package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/4
 */
public class _63_ {
    public static void main(String[] args) {
        int []p={8,9,2,5,4,7,1};
        System.out.println(maxProfit(p));
    }
    public static int maxProfit (int[] prices) {
        // write code here
        int max = 0;
        int min = Integer.MAX_VALUE;
        int minIndex=0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (minIndex>=i||i==prices.length-1) {
                min=Integer.MAX_VALUE;
                for (int j = i-1; j >= 0; j--) {
                    if (min > prices[j]) {
                        min = prices[j];
                        minIndex=j;
                    }
                }
            }
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }
}
