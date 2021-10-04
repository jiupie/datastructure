package com.wl.sort;

import java.util.Arrays;

/**
 * Doubble class
 *
 * @author 南顾北衫
 * @date 2020/5/12 11:16
 * @email 17674641491@163.com
 */
public class Bubble {
    public static void bubbleSort(int[] arr) {
        //控制次数
        for (int i = 0; i < arr.length; i++) {
            //交换位置
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
