package jz.jz9;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>        1 1 0 1 1 1 0 1 1 1 1
 * 输入: num = 1775(11011101111 2)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(0111 2)
 * 输出: 4
 * <p>
 *
 * @author 南顾北衫
 */
public class _m05_03_ {
    public static void main(String[] args) {
        System.out.println(reverseBits(1775));
        System.out.println(reverseBits2(1775));
    }

    public static int reverseBits(int num) {
        int max = 0;

        int tempNum = num;

        int cur = 0;
        int ins = 0;

        while (tempNum != 0) {
            if ((tempNum & 1) == 0) {
                ins = cur + 1;
                cur = 0;
            } else {
                cur += 1;
                ins += 1;
            }
            tempNum = tempNum >> 1;
            max = Math.max(max, ins);
        }
        return max;
    }


    public static int reverseBits2(int num) {
        char[] s = Integer.toBinaryString(num).toCharArray();

        int count = 0;

        int res = 0;

        int l = 0;
        int r = 1;

        int k = 1;

        while (r < s.length) {
            while (r < s.length) {
                r++;
                if (r < s.length) {
                    count++;
                }
                if (s[r - 1] == '0') {
                    if (k < 0) {

                    } else {
                        k--;
                    }
                    res = Math.max(res, r - l + count);
                    count = 0;
                    break;
                }
            }
            if (r == s.length) {
                break;
            }
            while (l < r) {
                l++;
                if (s[l] == '0') {
                    res = Math.max(res, r - l + count);

                } else {
                    break;
                }
            }
        }
        return res;
    }

}
