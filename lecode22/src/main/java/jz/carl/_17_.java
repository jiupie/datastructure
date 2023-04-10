package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class _17_ {
    public static void main(String[] args) {
//        String[] a = {"10", "0001", "111001", "1", "0"};//4, 3
                                    //dp  0 1
        String[] a = {"10","0001","111001","1","0"};//3   4
        // 10 1 0
        // 10 0001 1

        _17_ v = new _17_();
        System.out.println(v.findMaxForm(a, 3, 4));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];

        char[] chars = strs[0].toCharArray();
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n; j++) {
                if (count0 <= i && count1 <= j) {
                    dp[0][i][j] = 1;
                }
            }
        }



        for (int i = 1; i < strs.length; i++) {
            chars = strs[i].toCharArray();
            count0 = 0;
            count1 = 0;
            for (int i1 = 0; i1 < chars.length; i1++) {
                if (chars[i1] == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    //0的个数
                    //1的个数
                    if (j >= count0 && k >= count1) {
                        //dp[i - 1][m - count0][n - count1] + 1 选
                        //dp[i - 1][m][n] 不选
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count0][k - count1] + 1);
                    } else {
                        //选
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }
}
