package com.wl.sort;

import com.wl.sort.utils.Sort;

/**
 * SelectSort class
 * 选择排序
 *
 * @author 南顾北衫
 * @date 2020/5/12 14:06
 * @email 17674641491@163.com
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            T min = array[i];
            for (int j = i; j < array.length; j++) {
                if (cmp(min, array[j]) > 0) {
                    minIndex = j;
                    min = array[j];
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

}
