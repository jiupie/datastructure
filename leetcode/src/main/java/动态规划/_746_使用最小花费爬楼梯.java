package 动态规划;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _746_使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs(cost));

    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] temp = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            temp[i] = cost[i];
        }
        temp[temp.length - 1] = 0;
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            if (i <= 1) {
                result[i] = temp[i];
            }
        }
        return recuStairs3(temp, temp.length - 1, result);
//        return recuStairs2(temp, temp.length - 1, result);
//        return recuStairs(temp, temp.length - 1, 0);
    }

    public static int recuStairs3(int[] cost, int index, int[] result) {
        if (index < 2) {
            return cost[index];
        }
        for (int i = 0; i < cost.length; i++) {
            if (i < 2) {
                result[i] = cost[i];
                continue;
            }
            result[i] = cost[i]+Math.min(result[i - 1], result[i - 2]);
        }
        return result[index];
    }

    public static int recuStairs2(int[] cost, int index, int[] result) {
        if (index < 2 || result[index] != 0) {
            return result[index];
        }
        int a = cost[index] + recuStairs2(cost, index - 1, result);
        int b = cost[index] + recuStairs2(cost, index - 2, result);
        return Math.min(a, b);
    }


    public static int recuStairs(int[] cost, int index, int sum) {
        if (index == 0) {
            return cost[0];
        } else if (index == 1) {
            return cost[1];
        } else {
            int a = cost[index] + recuStairs(cost, index - 1, sum);
            int b = cost[index] + recuStairs(cost, index - 2, sum);
            return Math.min(a, b);
        }
    }
}
