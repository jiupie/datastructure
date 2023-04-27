package jz.carl.str;

/**
 * @author 南顾北衫
 * @date 2023/4/24
 */
public class _6_ {
    public int strStr(String haystack, String needle) {
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        boolean isContains = false;
        int length = haystackArr.length - needleArr.length;
        int index = 0;
        int tempIndex = index;

        while (index <= length) {
            tempIndex = index;
            for (int i = 0; i < needleArr.length; i++) {
                if (needleArr[i] == haystackArr[tempIndex]) {
                    tempIndex++;
                    isContains = true;
                } else {
                    isContains = false;
                    break;
                }
            }
            if (isContains) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public static void main(String[] args) {
        _6_ v = new _6_();
//        int i = v.strStr1("sadbutsad", "sad");
        int i = v.strStr1("aaaaa", "bba");
        System.out.println(i);
    }

    public int strStr1(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int[] next = getNext(needle);

        int j = -1;
        for (int i = 0; i < chars.length; i++) {
            while (j >= 0 && needleChars[j + 1] != chars[i]) {
                j = next[j];
            }
            if (needleChars[j + 1] == chars[i]) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static int[] getNext(String str) {
        int[] next = new int[str.length()];
        char[] chars = str.toCharArray();

        int j = -1;
        next[0] = j;
        // b  b  a  b  b
        //-1  0 -1  0  1
        for (int i = 1; i < chars.length; i++) {
            while (j >= 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }

            if (chars[i] == chars[j + 1]) {
                j++;
            }

            next[i] = j;
        }
        return next;
    }

}
