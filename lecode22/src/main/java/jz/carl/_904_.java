package jz.carl;

import java.util.HashMap;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fruit-into-baskets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 南顾北衫
 * @date 2023/4/18
 */
public class _904_ {
    public static void main(String[] args) {
        _904_ v = new _904_();
//        int[] arr = {1, 2, 1};
//        int[] arr = {1,2,3,2,2};
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(v.totalFruit(arr));
    }

    public int totalFruit(int[] fruits) {
        //只能有2个不一样的数

        int slow = 0;
        int count = 0;

        //不满足条件右边动， 满足条件左边动
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            Integer nums = map.get(fruits[i]);
            if (nums != null) {
                map.put(fruits[i], ++nums);
            } else {
                map.put(fruits[i], 1);
            }
            while (map.size() > 2) {
                Integer integer = map.get(fruits[slow]);
                if (--integer > 0) {
                    map.put(fruits[slow], integer);
                } else {
                    map.remove(fruits[slow]);
                }
                slow++;
            }
            count = Math.max(count, i - slow + 1);
        }
        return count;
    }
}
