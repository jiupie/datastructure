package com.wl.kmp;

import java.util.Arrays;

/**
 * kmpDemo class
 *
 * @author 南顾北衫
 * @date 2020/9/8 15:35
 * @email 17674641491@163.com
 */
public class kmpDemo {
    public static void main(String[] args) {
        String s1 = "BBABCDABDX";
        String s2 = "ABCDABD";
        int[] next = getNext(s2);
        System.out.println(Arrays.toString(next));
        int kmp = kmp(s1, s2, next);
        System.out.println(kmp);

    }


    public static int kmp(String str1, String str2, int next[]) {
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
        }
        return -1;
    }

    public static int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;

        int t = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(t) == str.charAt(i)) {
                next[i] = t + 1;
                i++;
                t++;
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


