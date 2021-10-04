package com.wl.tree;

import com.wl.tree.utils.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * Heap class
 * 堆 ，父节点大于等于子节点
 * 父节点 k ,子节点 2k+1,2k+2
 * 知道子节点求父节点，子节点为k,父节点为floor((k-1)/2) 数组元素从索引0开始
 * <p>
 * 0
 * 1       2
 * 3      4  5    6
 * <p>
 * 原地建堆方法
 * 自上而下过滤   下沉
 * 自下而上过滤   上浮
 *
 * @author 南顾北衫
 * @date 2020/9/6 19:45
 * @email 17674641491@163.com
 */
public class Heap<T extends Comparable<T>> implements BinaryTreeInfo {
    //存储元素的个数
    private int N;

    public T[] getItems() {
        return items;
    }

    //存储堆中的元素
    private T[] items;

    private Comparator<T> comparator;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    public Heap(int capacity, Comparator<T> comparator) {
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
        this.comparator = comparator;
    }

    /**
     * 下沉   自上而下过滤
     * O(nlogn)
     */
    public void createHeapSink(Comparable[] comparables) {
        items = (T[]) comparables;
        N = comparables.length;
        for (int i = (N >> 1) - 1; i >= 0; i--) {
            sink(i);
        }
    }

    /**
     * 上浮   自下而上过滤
     * O(n)
     */
    public void createHeapSwim(Comparable[] comparables) {
        items = (T[]) comparables;
        for (int i = 1; i < items.length; i++) {
            N++;
            swim(i);
        }
    }

    /**
     * 替换第0个元素
     * 然后再下沉
     */
    public void replace(T t) {
        if (N == 0) {
            N++;
            items[0] = t;
        } else {
            items[0] = t;
            sink(0);
        }
    }


    public int cmp(T t1, T t2) {
        return comparator == null ? t1.compareTo(t2) : comparator.compare(t1, t2);
    }

    //交换索引i和索引j的值
    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //插入元素
    public void insert(T item) {
        items[N] = item;
        //进行上浮操作，保持堆的性质
        swim(N);
        N++;
    }

    /**
     * 上浮操作，也就是把本节点跟父节点相比较，如果比父节点大就上浮，直到比到跟节点
     *
     * @param n
     */
    public void swim(int n) {
        while (n > 0) {
            //找到父节点
            int parent = (n - 1) / 2;
            //如果子节点比父节点小，那就不需要上浮
            if (cmp(items[parent], items[n]) > 0) {
                return;
            }
            swap(parent, n);
            n = (n - 1) / 2;
        }
    }

    public T delMax() {
        T t = items[0];
        //
        items[0] = items[N - 1];
        items[N - 1] = null;
        N--;
        //交换 下沉
        sink(0);
        return t;
    }

    /**
     * 下沉       O=logn
     *
     * @param k 索引
     */
    public void sink(int k) {
        //第一个叶子节点的索引=非叶子节点的个数
        //完成二叉树非叶子节点为n/2
        int half = N >> 1;

        //判断是否为非叶子节点
        while (k < half) {
            //左子节点索引
            int index = (k << 1) + 1;
            int maxIndex = index;
            //选出左右子树最大的
            if (index + 1 < N && cmp(items[index + 1], items[index]) > 0) {
                maxIndex = index + 1;
            }

            if (cmp(items[k], items[maxIndex]) >= 0) {
                break;
            }
            swap(maxIndex, k);
            k = maxIndex;
        }
    }

    /**
     * 返回根顶元素
     * @return
     */
    public T get(){
        return items[0];
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= N ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= N ? null : index;
    }

    @Override
    public Object string(Object node) {
        return items[(int) node];
    }


}
