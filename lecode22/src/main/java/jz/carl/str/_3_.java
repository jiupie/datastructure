package jz.carl.str;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @date 2023/4/24
 */
public class _3_ {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpace1(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }

        right = right + 2 * count;
        char[] chars1 = new char[right + 1];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                chars1[left++] = '%';
                chars1[left++] = '2';
                chars1[left++] = '0';
            } else {
                chars1[left++] = chars[i];
            }
        }
        return new String(chars1);
    }
}
