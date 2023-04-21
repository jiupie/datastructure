package jz.carl.hash;

/**
 * @author 南顾北衫
 * @date 2023/4/21
 */
public class _7_ {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] chars = ransomNote.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'a'] = ++arr[aChar - 'a'];
        }

        chars = magazine.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 'a'] = --arr[aChar - 'a'];
        }

        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }

        return true;
    }
}
