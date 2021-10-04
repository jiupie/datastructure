package com.wl;

import com.wl.graph.GraphImp;

import java.util.Scanner;

/**
 * 使用拓扑排序
 * 便利蜂手机 APP 由多个模块构成。模块更新时，可以指定依赖关系。若 A 模块依赖 B 模块，则 B 模块更新后，A 模块才可以更新。
 * <p>
 * 规定，不能存在循环依赖的模块。
 * <p>
 * 求：如何检测是否存在循环依赖的模块，存在循环返回Y，不存在返回N。
 * <p>
 * 3
 * A->B
 * B->C
 * C->B
 * <p>
 * Y
 */
public class Test2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        String[] num = new String[i];

        for (int i1 = 0; i1 < i; i1++) {
            num[i1] = scanner.next();
        }

        int[][] strings = new int[i][2];
        for (int i1 = 0; i1 < num.length; i1++) {
            strings[i1][0] = num[i1].charAt(0);
            strings[i1][1] = num[i1].charAt(num[i1].length() - 1);
        }

        GraphImp<Integer, Integer> graphImp = new GraphImp<>();

        for (int i1 = 0; i1 < strings.length; i1++) {
            graphImp.addEdge(strings[i1][0], strings[i1][1]);
        }

        System.out.println(graphImp.topologicSort2());

    }
}
