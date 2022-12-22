package jz.newcode.dynamic;

/**
 * @author 南顾北衫
 * @date 2022/12/22
 */
public class __92__ {
    //00110
    //0:        0:0   1:1
    //00:       0:0  1:1
    //001:      0:1 1:0
    //0011:     0:2 1:0
    //00110:    0:2 1:1
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int dp[][] = new int[s.length()][2];
        dp[0][0] = chars[0] == '0' ? 0 : 1;
        dp[0][1] = chars[0] == '1' ? 0 : 1;

        for (int i = 1; i < dp.length; i++) {
            if (chars[i] == '0') {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            if (chars[i] == '1') {
                dp[i - 1][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][1] =Math.min(dp[i - 1][0], dp[i - 1][1])+ 1;
            }
        }

        return Math.min(dp[chars.length - 1][0], dp[chars.length - 1][1]);
    }

    public static void main(String[] args) {

    }
}
