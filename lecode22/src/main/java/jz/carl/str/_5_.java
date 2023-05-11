package jz.carl.str;

/**
 * @author 南顾北衫
 * @date 2023/4/24
 */
public class _5_ {
    public String reverseLeftWords(String s, int n) {
        char[] chars = new char[s.length()];
        char[] oldCharArr = s.toCharArray();
        int index = 0;
        for (int i = n; i < s.length(); i++) {
            chars[index++] = oldCharArr[i];
        }
        for (int i = 0; i < n; i++) {
            chars[index++] = oldCharArr[i];
        }
        return new String(chars);
    }

    public String reverseLeftWords1(String s, int n) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = n - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        left = n;
        right = s.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        left = 0;
        right = s.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
