package jz.carl.str;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * <p>
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 *
 * @author 南顾北衫
 * @date 2023/4/24
 */
public class _2_ {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;

        //题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
        for (int i = 0; i < s.length(); i += 2 * k) {
            left = i;
            right = Math.min(i + k - 1, s.length() - 1);
            while (left <= right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    void change(int left, int right, char[] chars) {

    }

    public static void main(String[] args) {
        _2_ v = new _2_();
//        v.reverseStr()
    }
}
