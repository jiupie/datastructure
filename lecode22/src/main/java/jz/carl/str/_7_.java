package jz.carl.str;

/**
 * @author 南顾北衫
 * @date 2023/5/4
 */
public class _7_ {
    public static void main(String[] args) {
        _7_ v = new _7_();
        boolean abac = v.repeatedSubstringPattern("ababab");
        boolean isRepeat = v.repeatedSubstringPattern1("ababab");
        System.out.println(abac);
        System.out.println(isRepeat);
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = getNext(s);
        int length = s.length();

        if (next[length - 1] != -1 && length % (length - (next[length - 1] + 1)) == 0) {
            return true;
        }
        return false;
    }

    int[] getNext(String s) {
        int j = -1;
        char[] chars = s.toCharArray();
        int[] next = new int[chars.length];
        next[0] = j;
        for (int i = 1; i < chars.length; i++) {
            while (j >= 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }

            //相等
            if (chars[i] == chars[j + 1]) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }

    public boolean repeatedSubstringPattern1(String s) {
        int i = 0;
        int length = s.length();
        while (++i < length) {
            if (s.substring(length - i, length).equals(s.substring(0, i))) {
                if (s.substring(0, length - i).equals(s.substring(i, length))) {
                    return true;
                }
            }
        }
        return false;
    }
}
