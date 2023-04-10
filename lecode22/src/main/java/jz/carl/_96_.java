package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/7
 */
public class _96_ {


    //总j  以 i为根节点
    //左边节点为0,i-1  右边节点为i+1,j  j-i
    //
    //
    //

    public static void main(String[] args) {
        _96_ v = new _96_();
        System.out.println(v.numTrees(5));
    }


    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
