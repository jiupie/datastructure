package jz.jz9;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 *
 *
 *
 *
 * @author 南顾北衫
 */
public class _46_ {
    public static void main(String[] args) {
        System.out.println(System.getProperty("jdk.boot.class.path.append"));
        System.out.println(System.getProperty("java.class.path"));

    }

    public int translateNum(int num) {
        String s = num + "";
        int[] p = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {

        }

        return 0;
    }
}
