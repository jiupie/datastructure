package com.wl.array;

/**
 * ArrayDemo class
 *
 * @author 南顾北衫
 * @date 2020/9/7 12:58
 * @email 17674641491@163.com
 */
public class ArrayDemo {
    public static void main(String[] args) {
        /*Array<Integer> integerArray = new Array<>();
        integerArray.add(1);
        integerArray.add(2);
        integerArray.add(3);
        integerArray.add(4);
        integerArray.add(5);
        integerArray.add(6);
        integerArray.add(7);
        integerArray.add(8);
        integerArray.add(9);
        integerArray.add(10);
        System.out.println(integerArray.toString());
        integerArray.set(2, 44444);
        integerArray.remove(9);
        System.out.println(integerArray.toString());

        integerArray.add(2, 999);
        System.out.println(integerArray.toString());
        integerArray.add(6, 6666);
        System.out.println(integerArray.toString());*/
        Array<Integer> integerArray = new Array<>(50);
        integerArray.add(1);
        integerArray.add(2);
        System.out.println(integerArray.length());
        integerArray.remove(1);
        System.out.println(integerArray.length());
    }
}
