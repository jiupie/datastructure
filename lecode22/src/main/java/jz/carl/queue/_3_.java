package jz.carl.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 南顾北衫
 * @date 2023/4/26
 */
public class _3_ {
    class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        public void push(int x) {
            //队列
            //1. 1 2
            //
            while (!this.queue2.isEmpty()) {
                Integer poll = this.queue2.poll();
                this.queue1.add(poll);
            }

            this.queue2.add(x);

            while (!this.queue1.isEmpty()) {
                Integer poll = this.queue1.poll();
                this.queue2.add(poll);
            }
        }

        public int pop() {
            return this.queue2.poll();
        }

        public int top() {
            return this.queue2.peek();
        }

        public boolean empty() {
            return this.queue2.isEmpty();
        }
    }
}
