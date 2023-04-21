package jz.carl.hash;

import java.util.HashSet;

/**
 * @author 南顾北衫
 * @date 2023/4/20
 */
public class _4_ {
    public boolean isHappy(int n) {
        //123/1%10
        //123/10%10 12.3%10

        HashSet<Integer> set = new HashSet<>();
        String s = n + "";
        char[] chars = s.toCharArray();

        int sum = 0;
        while (true) {
            for (int i = 0; i < chars.length; i++) {
                int i1 = chars[i] - '0';
                sum += (i1 * i1);
            }
            if (sum == 1) {
                return true;
            } else {
                if (set.contains(sum)) {
                    return false;
                }
                set.add(sum);
                chars = (sum + "").toCharArray();
                sum = 0;
            }
        }

    }
}
