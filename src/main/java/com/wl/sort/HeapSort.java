package com.wl.sort;

import com.wl.sort.utils.Sort;

/**
 * Heap class
 *
 * @author 南顾北衫
 * @date 2020/9/6 19:45
 * @email 17674641491@163.com
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int heapSize;

    @Override
    protected void sort() {
       /* heapSize = array.length;
        //原地建堆
        for (int i = (heapSize >> 1)-1; i >= 0; i--) {
            sink(i);
        }
        //排序
        while (heapSize > 1) {
            swap(0, --heapSize);
            sink(0);
        }*/
        // 原地建堆（自下而上的下滤）
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            sink(i);
        }

        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            swap(0, --heapSize);

            // 对0位置进行siftDown（恢复堆的性质）
            sink(0);
        }
    }


    /**
     * 下沉       O=logn
     * 父节点比子节点小就下沉
     *
     * @param k
     */
    public void sink(int k) {
        //第一个叶子节点的索引=非叶子节点的个数
        //完成二叉树非叶子节点为n/2
        int half = heapSize >> 1;

        //判断是否为非叶子节点
        while (k < half) {
            //左子节点索引
            int index = (k << 1) + 1;
            int maxIndex = index;
            //选出左右子树最大的
            if (index + 1 < heapSize && cmp(array[index + 1], array[index]) > 0) {
                maxIndex = index + 1;
            }

            if (cmp(array[k], array[maxIndex]) >= 0) {
                return;
            }
            swap(maxIndex, k);
            k = maxIndex;
        }
    }

}
