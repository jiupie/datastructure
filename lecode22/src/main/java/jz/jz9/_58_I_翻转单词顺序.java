package jz.jz9;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @author 南顾北衫
 */
public class _58_I_翻转单词顺序 {
    public static void main(String[] args) {
        System.out.println(reverseWords("I am a student. "));
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        if (s.length() <= 1) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;

        int bound = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (left < right) {
            while (right != 0 && s.charAt(right - 1) != ' ') {
                right--;
            }
            String substring = s.substring(right, bound);
            stringBuilder.append(substring);
            if (right != 0) {
                stringBuilder.append(" ");
            }

            //去掉空格
            while (right != 0 && s.charAt(right - 1) == ' ') {
                right--;
            }
            bound = right;
        }
        return stringBuilder.toString();
    }
}
