package com.wl.stack;


import com.wl.array.Array;

/**
 * SimpleStack class
 *
 * @author 南顾北衫
 * @date 2020/9/15 20:59
 * @email 17674641491@163.com
 */
public class SimpleStack<T> extends Array<T> {

    /**
     * 入栈
     * @param element
     */
    public void push(T element) {
        add(element);
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        return remove(super.size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public T top() {
        return get(super.size() - 1);
    }

}
class test{
    public static void main(String[] args) {
        SimpleStack<String> stack = new SimpleStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
