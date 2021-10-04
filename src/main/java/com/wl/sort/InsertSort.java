package com.wl.sort;

import com.wl.sort.utils.Sort;

/**
 * InsertSort class
 *
 * @author 南顾北衫
 * @date 2020/3/11 15:08
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {


    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
