package jz.newcode.dynamic;

import java.util.Arrays;

public class __104__ {
    //dp[0]=1;
    //
    //dp[1]=1
    //    (1)+dp[0]=1
    //
    //dp[2]=2
    //    1+dp[1]=1
    //    2+dp[0]=1
    //
    //dp[3]= 4
    //    (1) +dp[2] =2
    //    (2) + dp[1] = 1
    //    (3)+dp[0]= 1
    //
    //dp[4]=
    //    (1)+dp[3]=4
    //    (2)+dp[2]=2
    //    (3)+dp[1]=1
    public static int combinationSum4(int[] nums, int target) {
        //[1,2,3]     target=4
        Arrays.sort(nums);
        int tar[] = new int[target + 1];
        tar[0] = 1;

        for (int i = 1; i < tar.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    tar[i] += tar[i - nums[j]];
                } else {
                    break;
                }
            }
        }


        return tar[target];
    }

    public static void main(String[] args) {

        int[] s = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(s, target));
    }
}
