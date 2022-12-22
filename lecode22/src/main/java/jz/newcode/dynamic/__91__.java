package jz.newcode.dynamic;

/**
 * @author 南顾北衫
 * @date 2022/12/9
 */
public class __91__ {
    //a[i][j]
    //  j+1  j-1
    //[17,2,17],
    //[16,16,5],
    //[14,3,19]


    // [3,5,3],
    // [6,17,6],
    // [7,13,18],
    // [9,10,18]
//    cost[i][0]=     min(dp[i-1][1],dp[i-1][2])+cost[i][0]
//    cost[i][1]=     min(dp[i-1][0],dp[i-1][2])+cost[i][1]
//    cost[i][2]=     min(dp[i-1][0],dp[i-1][1])+cost[i][2]
    public static int minCost(int[][] costs) {
        int length = costs.length;
        int dpi0 = minC(costs, length - 1 - 1, 0) + costs[length - 1][0];
        int dpi1 = minC(costs, length - 1 - 1, 1) + costs[length - 1][1];
        int dpi2 = minC(costs, length - 1 - 1, 2) + costs[length - 1][2];

        return Math.min(Math.min(dpi0, dpi1), dpi2);
    }

    //j=0

    //          3 0
    //     2 1                 2 2
    //  1 0       1 2         1 0       1 1
    //0 1   0 2  0 0  01   0 2   0 1  0 0   0 2
    public static int minC(int[][] costs, int i, int j) {
        System.out.println(i + ":" + j);
        if (i < 0) {
            return 0;
        }
        int v1 = vlaue(j + 1);
        int v2 = vlaue(j - 1);
        return Math.min(minC(costs, i - 1, v1) + costs[i][v1], minC(costs, i - 1, v2) + costs[i][v2]);
    }

    public static int vlaue(int j) {
        if (j < 0) {
            return 2;
        }
        if (j >= 3) {
            return 0;
        }
        return j;
    }


    static int dynamic(int[][] costs) {

        int p[][] = new int[costs.length][3];
        p[0][0] = costs[0][0];
        p[0][1] = costs[0][1];
        p[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            p[i][0] = Math.min(p[i - 1][1], p[i - 1][2]) + costs[i][0];

            p[i][1] = Math.min(p[i - 1][0], p[i - 1][2]) + costs[i][1];

            p[i][2] = Math.min(p[i - 1][0], p[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(p[costs.length - 1][0],
                        p[costs.length - 1][1]),
                p[costs.length - 1][2]);
    }

    public static void main(String[] args) throws InterruptedException {

//        int cos[][] = {{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}};
        int cos[][] = {{5, 8, 6},
                {19, 14, 13},
                {7, 5, 12},
                {14, 15, 17},
                {3, 20, 10}};
        System.out.println(dynamic(cos));
        Thread.currentThread().join();
    }
}
