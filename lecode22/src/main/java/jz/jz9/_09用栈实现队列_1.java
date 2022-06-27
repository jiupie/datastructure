package jz.jz9;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * @author 南顾北衫
 */
public class _09用栈实现队列_1 {


    public static void main(String[] args) {

    }

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public void CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(value);

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            return -1;
        } else {
            Integer pop = stack2.pop();
            if (pop != null) {
                return pop;
            } else {
                return -1;
            }
        }
    }
}
