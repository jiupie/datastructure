package 剑指offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _61_扑克牌中的顺子 {
    public static void main(String[] args) {
        int[] s = {0, 0, 2, 2, 5};
        System.out.println(isStraight(s));

    }

    public static boolean isStraight(int[] nums) {
        //先排序
        //统计0的个数
        //把不是0的存入hashset中
        Arrays.sort(nums);

        int flag = 0;
        int max = nums[4];
        int min = 0;
        int c = 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                flag++;
            } else {
                hashSet.add(nums[i]);
            }
        }

        if (hashSet.size() != nums.length - flag) {
            return false;
        }

        min = nums[flag];
        c = max - min;
        return c < 5;
    }
}
