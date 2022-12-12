package jz.jz9;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
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
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 南顾北衫
 * @description
 * @date 2022/7/10
 */
public class _48_最长不含重复字符的子字符串_ {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int num = 1;
        int maxNum = 1;
        while (right < s.length()) {
            String str = s.substring(left, right);
            while (right < s.length()) {
                right++;
                if (right < s.length()) {
                    //更新状态
                    str = s.substring(left, right);
                    if (str.indexOf(s.charAt(right)) == -1) {//可以加入
                        num++;
                    } else {
                        maxNum = Math.max(num, maxNum);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (right == s.length()) {
                break;
            }

            while (left < right) {
                str = s.substring(left, right);
                left++;
                if (str.indexOf(s.charAt(right)) == -1) {//可以加入
                    break;
                } else {

                }
            }


        }

        return maxNum;
    }

}
