package jz.jz9;

/**
 * 兑换零钱(一)
 * https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tab=note
 * @author 南顾北衫
 * @description
 * @date 2022/9/7
 */
public class _70_兑换零钱 {
    public static void main(String[] args) {
        int []arr={5,3,2};
        System.out.println(minMoney(arr, 20));
    }
    public static int minMoney (int[] arr, int aim) {
        // write code here
        int []dp = new int[aim + 1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < i&&dp[i - arr[j]]>0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]]+1);
                }
                if (arr[j] == i) {
                    dp[i] = 1;
                }
            }
            if(dp[i]==Integer.MAX_VALUE){
                dp[i]=-1;
            }
        }
        return dp[aim];
    }
}
