package jz.carl;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * <p>
 * 输出：3
 * <p>
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * <p>
 * 输出：5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-length-of-repeated-subarray
 *
 * @author 南顾北衫
 * @date 2023/4/4
 */
public class _718_ {

    //nums1 = [1,2,3,2,1]
    //nums2 = [4,7,3,2,1]


    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];


        int res = -1;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > res || res == -1) {
                    res = dp[i][j];
                }
            }
        }

        return res;
    }
}
