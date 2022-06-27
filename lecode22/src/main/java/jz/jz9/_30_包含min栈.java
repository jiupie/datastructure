package jz.jz9;

import java.util.Arrays;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 *
 * @author 南顾北衫
 */
public class _30_包含min栈 {


    public static void main(String[] args) {

    }


    int[] s;

    int index = 0;

    /**
     * initialize your data structure here.
     */
    public void MinStack() {
        s = new int[20000];
    }


    public void push(int x) {
        s[index++] = x;
    }


    public void pop() {
        s[--index] = Integer.MAX_VALUE;
    }

    public int top() {
        return s[index - 1];
    }

    public int min() {

        int min = s[0];
        for (int i = 1; i < index; i++) {
            if (min > s[i]) {
                min = s[i];
            }
        }
        return min;
    }
}

/**
 * ["MinStack","push","push","push","push","min","pop","min","pop","min","pop","min"]
 * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
 * [null,null,null,null,null,0,null,0,null,0,null,0]
 * [null,null,null,null,null,0,null,0,null,0,null,2]
 * [2],
 */
