package jz.jz9;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/4/2
 */
public class _338_比特位计数 {
    public static void main(String[] args) {
        int[] ints = countBits(5);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] countBits(int n) {
        int res[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < 2) {
                res[i] = i;
            } else {
                if(i%2==0){
                    //偶数
                    res[i] = res[i / 2];
                }else {
                    //奇数
                    res[i] = res[i -1]+1;
                }
            }
        }

        return res;
    }
}
