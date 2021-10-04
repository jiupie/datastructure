package 贪心策略;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 解法：
 * 再数组首尾两端加上0就可以忽略边界问题
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _605_种花问题 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};


        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        int temp[] = new int[flowerbed.length + 2];

        temp[0] = 0;
        temp[flowerbed.length] = 0;
        for (int i = 1; i < temp.length - 1; i++) {
            temp[i] = flowerbed[i - 1];
        }

        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i] == 0 && temp[i + 1] == 0 && temp[i - 1] == 0) {
                temp[i] = 1;
                n--;
            }
            if (n == 0) {
                return true;
            }
        }

        return false;
    }
}
