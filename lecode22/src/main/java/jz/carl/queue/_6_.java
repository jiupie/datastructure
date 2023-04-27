package jz.carl.queue;

import java.util.Stack;

/**
 * @author 南顾北衫
 * @date 2023/4/27
 */
public class _6_ {
    public static void main(String[] args) {
        _6_ v = new _6_();
        String [] s={"4","13","5","/","+"};
        System.out.println(v.evalRPN(s));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    if ("+".equals(token)) {
                        stack.push(num1 + num2);
                    } else if ("-".equals(token)) {
                        stack.push(num1 - num2);
                    } else if ("*".equals(token)) {
                        stack.push(num1 * num2);
                    } else {
                        stack.push(num1 / num2);
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
