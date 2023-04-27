package jz.carl.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 南顾北衫
 * @date 2023/4/27
 */
public class _7_ {
    //超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ints = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            ints[index++] = max;
        }

        return ints;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ints = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //单调递减

            //队尾 元素
            while (!arrayDeque.isEmpty() && nums[arrayDeque.pollLast()] <= nums[i]) {
                arrayDeque.pollLast();
            }

            //加入该元素到队尾
            arrayDeque.addLast(i);

            //队头
            if (arrayDeque.peekFirst() <= i - k) {
                arrayDeque.pollLast();
            }

            if (i + 1 >= k) {
                ints[index++] = nums[arrayDeque.peekFirst()];
            }
        }

        return ints;
    }
}
