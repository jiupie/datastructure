package com.wl.kmp;

import java.util.Arrays;

/**
 * Kmp class
 *
 * @author 南顾北衫
 * @date 2020/9/8 13:16
 * @email 17674641491@163.com
 */
public class Kmp {

    public static void main(String[] args) {
        String s1 = "BBCABCDABABCDABCDABDE";
        String s2 = "ABCDABA";
        int[] next = getNext(s2);
        System.out.println(Arrays.toString(next));
        int index1 = kmp2(s1, s2, next);
        System.out.println(index1);

    }

    public static int kmp2(String str1, String str2, int next[]) {
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (j == 0 || str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }


        if (j == str2.length()) {
            return i - j;
        } else {
            return -1;
        }

    }


    public static int[] getNext(String str) {
        int t = 0, i = 1;

        int[] next = new int[str.length()];
        next[0] = 0;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(t)) {
                next[i] = t + 1;
                ++i;
                ++t;
            } else if (t > 0) {
                t = next[t - 1];
            } else if (t == 0) {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }
}
