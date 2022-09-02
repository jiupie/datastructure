package jz.jz9;

/**
 * @author 南顾北衫
 * @date 2022/9/2
 */
public class _15_二进制中1 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }

    public static int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
