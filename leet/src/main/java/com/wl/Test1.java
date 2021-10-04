package com.wl;


import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 无向图是否有环
 * <p>
 * 假设我们有一个连通的无向图，里面可能最多存在一个环，检测输入的图是否有环。
 * <p>
 * 这个图有n个不重复的顶点，输入的图的边[a,b]，满足a<b。如果有环输出Y，否则输出N。
 * <p>
 * n表示输入数组的长度，数组里每个数字都小于n。 (n<=10000)
 * <p>
 * 1--2–3
 * <p>
 * |    |
 * <p>
 * 5–4
 * <p>
 * 如上图，2-3-4-5是一个环
 */
public class Test1 {
    //[[1,2],[2,5],[1,4]]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

        StringTokenizer stringTokenizer = new StringTokenizer(next, "[],");
        int[][] i = new int[stringTokenizer.countTokens() / 2][2];
        System.out.println(stringTokenizer.countTokens() / 2);
        int temp = 0;
        int num = 0;
        while (stringTokenizer.hasMoreElements()) {
            i[temp][num] = Integer.parseInt(stringTokenizer.nextElement().toString());
            if (num == 1) {
                num = 0;
                temp++;
            } else {
                num++;
            }
        }


    }
}
