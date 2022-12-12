package jz.newcode.dynamic;

public class __107__ {

    public static int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == -1) {
                    int dp1 = -1;
                    int dp2 = -1;
                    if (i - 1 >= 0) {
                        if (dp[i - 1][j] == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp1 = dp[i][j - 1] + 1;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (dp[i][j - 1] == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp2 = dp[i][j - 1] + 1;
                        }
                    }
                    if (dp[i][j] == -1) {
                        dp[i][j] = Math.min(dp1, dp2);
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == -1) {
                    int dp1 = -1;
                    int dp2 = -1;

                    if (i + 1 < dp.length) {
                        if (dp[i + 1][j] == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp1 = dp[i + 1][j] + 1;
                        }
                    }
                    if (j + 1 < dp[0].length) {
                        if (dp[i][j + 1] == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp1 = dp[i][j + 1] + 1;
                        }


                    }

                    if (dp[i][j] ==-1){
                        dp[i][j] = Math.min(dp1, dp2);
                    }

                }
            }

        }

        return dp;
    }

    public static void main(String[] args) {

    }
}
