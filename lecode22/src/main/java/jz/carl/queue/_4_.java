package jz.carl.queue;

import java.util.Stack;

/**
 * @author 南顾北衫
 * @date 2023/4/26
 */
public class _4_ {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (!stack.isEmpty() && stack.peek().equals(aChar)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
