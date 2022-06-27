package jz.jz9;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * <p>
 * 输出："bab"
 * <p>
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * <p>
 * 输出："bb"
 * <p>
 * 字符串"PATZJUJZTACCBCC"的最长回文子串为"ATZJUJZTA",长度为9。
 *
 * @author 南顾北衫
 */
public class _5_ {
    public static void main(String[] args) {
//        String str = "PATACCBCC";
//        String str = "PATZJUJZTACCBCC";
//        String str = "babad";
        String str = "cbbd";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        char[] chars = s.toCharArray();

        String res = "";

        int cur = 0;
        int l = 0;
        int r = 0;

        boolean state = false;
        for (int i = 0; i < chars.length; i++) {
            cur = i + 1;
            l = cur - 1;
            r = cur + 1;
            while (l >= 0 && r < chars.length) {
                if (chars[l] == chars[r]) {
                    l--;
                    r++;
                    state = true;
                } else {
                    if (state) {
                        String tempRes = s.substring(l + 1, r);
                        if (res.length() < tempRes.length()) {
                            res = tempRes;
                        }
                        state = false;
                    }
                    break;
                }
            }
            if (state) {
                String tempRes = s.substring(l + 1, r);
                if (res.length() < tempRes.length()) {
                    res = tempRes;
                }
                state = false;
            }
        }

        return res;
    }
}
