package jz.carl;

import java.util.Arrays;

public class _416_ {
    public static void main(String[] args) {
        _416_ v = new _416_();
        System.out.println(v.canPartition(new int[]{1, 5, 11, 5}));
    }
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);

        int l=0;
        int r=nums.length-1;
        int lValue=nums[l];
        int rValue=nums[r];

        while(l<r){
            if(rValue<lValue){
                r--;
                if(l==r){
                    break;
                }
                rValue+=nums[r];
            }else{
                l++;
                if(l==r){
                    break;
                }
                lValue+=nums[l];
            }
        }
        return lValue == rValue;
    }
}
