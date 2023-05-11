package jz.carl.str;

/**
 * @author 南顾北衫
 * @date 2023/4/24
 */
public class _1_ {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tempChar = s[right];
            s[right] = s[left];
            s[left] = tempChar;
            left++;
            right--;
        }
    }
}
