package com.wl.sort;

import com.wl.sort.utils.Sort;

/**
 * Mergesort class
 *
 * @author 南顾北衫
 * @date 2020/10/16 11:29
 * @email 17674641491@163.com
 */
public class Mergesort<T extends Comparable<T>> extends Sort<T> {
    T[] leftArray;


    public void sort(T[] array, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int mid = (end + begin) >> 1;
        sort(array, begin, mid);
        sort(array, mid, end);
        merge(array, begin, mid, end);
    }

    /**
     * 合并
     */
    private void merge(T[] array, int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        for (int i = 0; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        while (li < le) {
            if (ri < re && cmp(leftArray[li],array[ri])>0) {
                array[ai] = array[ri];
                ai++;
                ri++;
            } else {
                array[ai] = leftArray[li];
                ai++;
                li++;
            }
        }
    }

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(array, 0, array.length);
    }
}
