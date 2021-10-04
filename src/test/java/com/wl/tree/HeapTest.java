package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTrees;
import org.junit.Test;

import java.util.Comparator;


/**
 * HeapTest class
 *
 * @author 南顾北衫
 * @date 2020/10/17 18:40
 * @email 17674641491@163.com
 */
public class HeapTest {

    @Test
    public void insert() {
        Integer[] integer = new Integer[]{
                10, 75, 66, 45, 83, 27, 53, 62, 91, 16
        };
        Heap<Integer> tHeap = new Heap<>(integer.length);
        for (int i = 0; i < integer.length; i++) {
            tHeap.insert(integer[i]);
        }
        Comparable[] comparables = tHeap.getItems();
        System.out.println(tHeap.delMax());
        System.out.println(tHeap.delMax());
        System.out.println(tHeap.delMax());
        System.out.println(tHeap.delMax());
        System.out.println(tHeap.delMax());
        System.out.println(tHeap.delMax());
        comparables = tHeap.getItems();
        System.out.println("==========");
        for (Comparable comparable : comparables) {
            System.out.println(comparable);
        }
    }

    @Test
    public void heap() {
        Integer[] integer = new Integer[]{
                10, 75, 66, 45, 83, 27, 53, 62, 91, 16
        };
        //大顶堆和小顶堆只要改变比较策略即可
        //小顶堆
        Heap<Integer> tHeap = new Heap<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //大顶堆
        Heap<Integer> tHeap2 = new Heap<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        tHeap.createHeapSink(integer);
        tHeap.replace(100);
        BinaryTrees.println(tHeap);

        tHeap.replace(1);
//        tHeap.createHeapSwim(integer);
        BinaryTrees.println(tHeap);
    }

    /**
     * topk 问题 使用小顶堆O(nlogk),也就是取出前K个
     * 堆小于K时，直接插入，对大于K时，判断是否大于小根堆的根顶元素。
     */
    @Test
    public void topk() {
        Integer[] integer = new Integer[]{
                10, 75, 66, 45, 83, 27, 53, 62, 91, 16
        };
        //小顶堆
        Heap<Integer> tHeap = new Heap<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int k = 5;
        for (int i = 0; i < integer.length; i++) {
            if (i < k) {
                tHeap.insert(integer[i]);
            } else if (integer[i] > tHeap.get()) {
                tHeap.replace(integer[i]);
            }
        }
        BinaryTrees.println(tHeap);
    }


}