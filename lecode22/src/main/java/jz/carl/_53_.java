package jz.carl;

public class _53_ {

    //5,4,-1,7,8
    //5,4
    //5,4,-1
    //5,4,-1,7
    //

    //-2,1,-3,4,-1,2,1,-5,4
    //sum(0) -2
    //sum(0) -2 sum(0,1) -1 sum(1) 1
    //sum(0)  sum(0,1) sum(1)  sum(0,2) sum(2)
    public int maxSubArray(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i - 1]+nums[i], nums[i]) ;
            }
        }

        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

}
