package jz.carl.queue;

import java.util.Stack;

/**
 * @author 南顾北衫
 * @date 2023/4/26
 */
public class _2_ {
    class MyQueue {
        private Stack<Integer> stack1 = new Stack();
        private Stack<Integer> stack2 = new Stack();

        public MyQueue() {

        }

        public void push(int x) {
            //1 2 3
            //
             while (!stack2.isEmpty()) {
                Integer peek = stack2.pop();
                stack1.push(peek);
            }

            stack1.push(x);
            while (!stack1.isEmpty()) {
                Integer peek = stack1.pop();
                stack2.push(peek);
            }
        }

        public int pop() {
            return stack2.pop();

        }

        public int peek() {
           return stack2.peek();
        }

        public boolean empty() {
            if (stack2.isEmpty()) {
                return true;
            }
            return false;
        }
    }

}
