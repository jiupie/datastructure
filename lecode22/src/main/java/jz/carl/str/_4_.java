package jz.carl.str;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @date 2023/4/24
 */
public class _4_ {
    public static void main(String[] args) {
//        String s = "a  hello world  a";
        String s = " a  hello world  b ";
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";
        _4_ v = new _4_();
        System.out.println(Arrays.toString(v.reverseWords(s).toCharArray()));
        System.out.println(Arrays.toString(v.reverseWords(s1).toCharArray()));
        System.out.println(Arrays.toString(v.reverseWords(s2).toCharArray()));
        System.out.println(Arrays.toString(v.reverseWords(s3).toCharArray()));
    }

    public String reverseWords(String s) {
        char[] newChars = new char[s.length() + 1];

        int i = s.length() - 1;
        char[] oldChars = s.toCharArray();

        int tempIndex = 0;
        int index = 0;
        boolean isHasChar = false;

        while (i >= 0) {
            if (oldChars[i] == ' ') {
                if (isHasChar) {
                    tempIndex = i + 1;
                    while (tempIndex < s.length() && oldChars[tempIndex] != ' ') {
                        newChars[index++] = oldChars[tempIndex++];
                    }
                    newChars[index++] = ' ';
                    isHasChar = false;
                }
                i--;
                continue;
            }

            if (i == 0) {
                //i==0特殊情况处理
                tempIndex = i;
                while (tempIndex < s.length() && oldChars[tempIndex] != ' ') {
                    newChars[index++] = oldChars[tempIndex++];
                }
                newChars[index++] = ' ';
            }

            isHasChar = true;
            i--;
        }

        //index-1 去掉最后一个空格
        char[] resChar = new char[index - 1];
        System.arraycopy(newChars, 0, resChar, 0, index - 1);
        return new String(resChar);
    }
}
