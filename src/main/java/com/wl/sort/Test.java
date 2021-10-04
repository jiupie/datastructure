package com.wl.sort;

import com.wl.sort.utils.Integers;
import com.wl.sort.utils.Sort;
import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Test class
 *
 * @author 南顾北衫
 * @date 2020/5/16 17:09
 * @email 17674641491@163.com
 */
public class Test {
    public static void main(String[] args) {
        Integer[] array = Integers.random(100000, 1, 1000000);
//        Integer[] array = {10, 20, 11, 1, 12, 3, 5, 14, 2};

        Mergesort<Integer> integerMergesort = new Mergesort<>();
        QuickSort<Integer> tQuickSort = new QuickSort<>();
        SelectSort<Integer> tSelectSort = new SelectSort<>();
        InsertSort<Integer> tInsertSort = new InsertSort<>();
        ShellSort<Integer> tShellSort = new ShellSort<>();
        HeapSort<Integer> tHeapSort = new HeapSort<>();
        testSorts(array, tHeapSort, integerMergesort, tQuickSort, tSelectSort, tInsertSort, tShellSort);
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Assert.assertTrue(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

}
