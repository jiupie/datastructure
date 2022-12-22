package jz.newcode.dynamic;

/**
 * @author 南顾北衫
 * @date 2022/12/12
 */
public class __102__ {
    // + 前p项和
    // - 前q项和
    // p-q=target
    // p+q=sum
    // p = (sum - target) / 2=

    //dp[0][0]=1
    //dp[0][1]=0
    //dp[0][2]=0

    //dp[1][0]=
    //dp[0][0]=1

    //dp[1][1]=
    //dp[0][0]

    //dp[1][2]=
    //dp[1][2-1]

    //dp[1][3]=
    //dp[i-1][j]
    // 选了数组中的数字：dp[0][3-1]


    //[1,0] 1
    //neg=(sum-target)/2=0

    //dp[3][1]
    //dp[0][0]=1  dp[0][1]=0
    //dp[1][0]=    dp[1][1]=


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int neg = (sum - target) / 2;
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < dp[0].length; j++) {
                if (j < num) {
                    dp[i][j] += dp[i - 1][j];
                } else {
                    dp[i][j]+= dp[i - 1][j] + dp[i - 1][j - num];
                }

            }
        }


        return dp[nums.length][neg];
    }

    public static void main(String[] args) {

    }
}
