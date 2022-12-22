package jz.newcode.dynamic;

import java.util.List;

/**
 * @author 南顾北衫
 * @date 2022/12/22
 */
public class __100__ {
    public int minimumTotal(List<List<Integer>> triangle) {

//   2
//  3 4
// 6 5 7
//   s[2][0]
// s[1][0] s[1][-1]
//s[0][0]  s[0][-1]
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);

        int size = triangle.size();
        for (int i = 1; i < size; i++) {
             for (int k = 0; k < triangle.get(i).size(); k++) {

                int p1 = Integer.MAX_VALUE;
                int p2 = Integer.MAX_VALUE;

                if (k - 1 >= 0) {
                    p1 = dp[i - 1][k - 1];
                }

                if (k < triangle.get(i - 1).size()) {
                    p2 = dp[i - 1][k];
                }
                dp[i][k] = Math.min(p1, p2) + triangle.get(i).get(k);
            }
        }

        int[] ints = dp[dp.length - 1];
        int min = ints[0];
        for (int anInt : ints) {
            if (anInt < min) {
                min = anInt;
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
