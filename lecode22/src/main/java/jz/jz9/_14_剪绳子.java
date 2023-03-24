package jz.jz9;

import java.math.BigInteger;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * <p>
 *
 * @author 南顾北衫
 * @date 2023/3/23
 */
public class _14_剪绳子 {
    public static void main(String[] args) {

        System.out.println(cuttingRope(8));
//        System.out.println(cuttingRope(5));
    }

    public static int cuttingRope(int n) {
        //2 =  2
        //3= 1+2     1*2=2  2
        //4= 2+2     2*2=4  4 f(2)*2  f(1)*3
        //5= 2+3     2*3=6  5 f(3)*2  f(2)*3
        //6= 3*3     3*3=9    f(4)*2  f(3)*3
        //7= 2+2+3   2*2*3=12
        //8= 2+2+2+2 16    f(6)*2  f(5)*3
        //9= 2+2+3+2  24
        if (n <= 2) {
            return 1;
        }
        BigInteger[] s = new BigInteger[n + 1];
        s[0] = BigInteger.valueOf(0);
        s[1] = BigInteger.valueOf(1);
        s[2] = BigInteger.valueOf(2);
        for (int i = 3; i <= n; i++) {
            BigInteger num1 = BigInteger.valueOf(1);
            if (i - 2 <= 2) {
                num1 = BigInteger.valueOf(2 * (i - 2));
            } else {
                num1 = s[i - 2].multiply(BigInteger.valueOf(2));
            }

            BigInteger num2 = BigInteger.valueOf(1);
            if (i - 3 <= 3) {
                num2 = BigInteger.valueOf(3 * (i - 3));
            } else {
                num2 = s[i - 3].multiply(BigInteger.valueOf(3));
            }
            s[i] = num1.compareTo(num2) > 0 ? num1 : num2;
        }
        return s[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
