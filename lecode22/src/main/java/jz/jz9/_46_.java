package jz.jz9;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * <p>
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 *
 * @author 南顾北衫
 */
public class _46_ {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
    //12258
    //需要注意特殊情况，有0的时候
    //12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
    //1    b
    //12   bc m
    //122  bc-c b-w  m-c
    //1225 bcc-f  `bc-z`  bw-f  mc-f  `m-z`
    //12258

    //a[i-1]a[i]<26     =dp[i-1]+dp[i-2]

    public static int translateNum(int num) {
        String s = num + "";
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = 1;


        for (int i = 1; i < chars.length; i++) {
            int tempNum = Integer.parseInt(chars[i - 1] + String.valueOf(chars[i]));
            //需要注意特殊情况，有0的时候 例如：06，还是只有6
            if (tempNum < 26 && chars[i - 1] != '0') {
                if (i - 2 < 0) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }

}
