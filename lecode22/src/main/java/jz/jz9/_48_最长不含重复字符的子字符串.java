package jz.jz9;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author 南顾北衫
 */
public class _48_最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring(" b"));
        System.out.println(lengthOfLongestSubstring("  "));
        System.out.println(lengthOfLongestSubstring("s"));
        System.out.println(lengthOfLongestSubstring("qrsvbspk"));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = -1;

        int maxNum = 0;

        boolean valid = false;

        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            //右边扩大
            right++;
            if (right >= s.length()) {
                return maxNum;
            }


            char c = s.charAt(right);


            if (!map.containsKey(c)) {
                map.put(c, right);
                valid = false;
            } else {
                valid = true;
            }

            maxNum = Math.max(maxNum, map.size());
//
//            if (right == s.length()) {
//                return maxNum;
//            }
            while (valid) {

                if (left >= right) {
                    valid = false;
                    break;
                }
                map.remove(s.charAt(left));
                char cRight = s.charAt(right);
                left++;
                if (!map.containsKey(cRight)) {
                    map.put(c, right);
                    valid = false;
                }

            }

        }
        return maxNum;
    }
}
