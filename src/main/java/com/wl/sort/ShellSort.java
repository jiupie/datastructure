package com.wl.sort;

import com.wl.sort.utils.Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * shell class
 *
 * @author 南顾北衫
 * @date 2020/3/11 13:17
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {


    @Override
    protected void sort() {
        List<Integer> steps = generateSequence();
        for (Integer step : steps) {
            sort(step);
        }
    }

    private void sort(Integer step) {
        /*for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }*/
        for (int col = 0; col < step; col++) {
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    public List<Integer> generateSequence() {
        List<Integer> list = new ArrayList<>();
        for (int i = (array.length >> 1); i > 0; i >>= 1) {
            list.add(i);
        }
        return list;
    }


}
