package jz.jz9;

import java.util.Stack;

/**
 * 入栈的时候入b栈
 *
 * 出队头的时候
 *      b栈全部pop a栈把b栈pop的元素 push进a栈  然后a在pop
 *
 * @author 南顾北衫
 */
public class _09用栈实现队列 {

    static class CQueue {

        /**
         * 中间栈
         */
        private Stack<Integer> stack1 = null;

        /**
         * 最终栈
         */
        private Stack<Integer> stack2 = null;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            //入栈b
            stack2.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                return -1;
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            Integer pop = stack1.pop();

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return pop;
        }


    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());


    }
}
