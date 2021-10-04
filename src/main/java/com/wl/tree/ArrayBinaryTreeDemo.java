package com.wl.tree;

/**
 * ArrayBinaryTree class
 *
 * @author 南顾北衫
 * @date 2020/6/2 18:36
 * @email 17674641491@163.com
 */
public class ArrayBinaryTreeDemo {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree();
        arrayBinaryTree.preOder(arr,0);
    }

}

/**
 * 顺序二叉树
 * 满二叉树
 * 完成二叉树
 * 第n个元素的左子节点 2n+1
 * 第n个元素的右子节点 2n+2
 */
class ArrayBinaryTree {
    private int arr[];

    public ArrayBinaryTree() {
    }

    /**
     * 先序遍历 中左右
     *
     * @param arr
     * @param index
     */
    public  void preOder(int arr[], int index) {
        System.out.println(arr[index]);
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < arr.length) {
            preOder(arr, left);
        }
        if (right < arr.length) {
            preOder(arr, right);
        }
    }
}
