package jz.jz9;

import java.util.Arrays;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 *
 * 解题思路：
 * 1.先排序
 * 2.获取当前0的个数
 * 3.下一个值和预期值做比较，分别对> < =做不同的操作
 *
 * @author 南顾北衫
 * @date 2022/8/25
 */
public class _61_ {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 2, 4};
        System.out.println(isStraight(nums));
    }

    public static boolean isStraight(int[] nums) {
        if (nums == null) {
            return false;
        }

        Arrays.sort(nums);
        int replaceCount = 0;

        int except = -1;

        for (int num : nums) {
            if (num == 0) {
                replaceCount++;
            } else {
                if (except == -1) {
                    except = num + 1;
                } else if (num > except) {
                    replaceCount -= (num - except);
                    if (replaceCount < 0) {
                        return false;
                    }
                    except = num + 1;
                } else if (num < except) {
                    return false;
                } else if (num == except) {
                    except = num + 1;
                }
            }
        }
        return true;
    }
}
