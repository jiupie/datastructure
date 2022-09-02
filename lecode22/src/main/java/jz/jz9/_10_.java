package jz.jz9;

/**
 * @author 南顾北衫
 * @date 2022/9/1
 */
public class _10_ {
    public static void main(String[] args) {
        System.out.println(fib(45));
        System.out.println(fib1(45));
    }

    //递归
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
        //2   1
    }

    //动态规划
    public static int fib1(int n) {
        int[] p = new int[n + 1];
        for (int i = 0; i < p.length; i++) {
            if (i < 2) {
                p[i] = i;
            } else {
                p[i] = (p[i - 1] + p[i - 2]) % 1000000007;
            }
            //p[2]=p[1]+p[0]=1;
            //p[3]=p[2]+p[1]=2
            //p[4]=p[3]+p[2]=2+1=3
            //p[5]=p[4]+p[3]=5
        }

        return p[n];
//        return p[n];
    }

}
