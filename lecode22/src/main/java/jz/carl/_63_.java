package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/7
 */
public class _63_ {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (dp[i - 1][0] == 0 || obstacleGrid[i][0] == 1 || obstacleGrid[0][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (dp[0][i - 1] == 0 || obstacleGrid[0][i] == 1 || obstacleGrid[0][0] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1 || obstacleGrid[0][0] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
//[
// [0,1,0,0,0],
// [1,0,0,0,0],
// [0,0,0,0,0],
// [0,0,0,0,0]
// ]
