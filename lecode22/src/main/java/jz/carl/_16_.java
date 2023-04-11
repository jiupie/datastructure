package jz.carl;

/**
 * 目标和
 *
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class _16_ {

    public static void main(String[] args) {
        _16_ v = new _16_();
        int[] arr = {1, 1, 1, 1, 1};//5
//        int[] arr = {1000};
//        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 1};

        System.out.println(v.findTargetSumWays(arr, 3));
        System.out.println(v.findTargetSumWays1(arr, 3));
    }


    public int findTargetSumWays(int[] nums, int target) {
        //x-(sum-x)=target
        //x=(target+sum)/2
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        int i1 = Math.abs(target) + sum;
        int x = i1 / 2;
        if (target > sum || (i1 & 1) == 1) {
            return 0;
        }
        int[][] dp = new int[nums.length][x + 1];

        dp[0][nums[0]] = 1;
        dp[0][0] = 1;
        if (nums[0] == 0) {
            dp[0][0] = 2;
        }


        //组合问题
        //物品
        for (int i = 1; i < nums.length; i++) {
            //包
            for (int j = 0; j <= x; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length - 1][x];
    }

    private int count;

    public int findTargetSumWays1(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return count;
    }

    /*
   0 (3,0,0)
    \
     1 (3,1,1)
      \
       2 (3,2,2)
        \
         3 (3,3,3)
          \
           4 (3,4,4)                5 (3,4,3)
            \
             5 (3,5,5)
              \                   /


     */


    public void backTracking(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            //双递归
            backTracking(nums, target, index + 1, sum + nums[index]);
            backTracking(nums, target, index + 1, sum - nums[index]);
        }

    }


}
