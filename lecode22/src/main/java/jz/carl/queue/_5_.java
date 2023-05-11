package jz.carl.queue;

import java.util.Stack;

/**
 * @author 南顾北衫
 * @date 2023/4/27
 */
public class _5_ {
    public static void main(String[] args) {
        _5_ v = new _5_();
        System.out.println(v.removeDuplicates("abbac"));
    }

    public String removeDuplicates(String s) {
        //abbac
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.isEmpty()) {
                if (stack.peek().equals(aChar)) {
                    stack.pop();
                } else {
                    stack.add(aChar);
                }
            } else {
                stack.add(aChar);
            }
        }
        Character[] characters = stack.toArray(new Character[0]);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characters) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
