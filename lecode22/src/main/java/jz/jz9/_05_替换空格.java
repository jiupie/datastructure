package jz.jz9;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author 南顾北衫
 */
public class _05_替换空格 {
    public static void main(String[] args) {
        String s = " dfad dafsdfs sadf";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
