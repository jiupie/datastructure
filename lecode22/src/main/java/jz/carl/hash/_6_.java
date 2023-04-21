package jz.carl.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数和
 *
 * @author 南顾北衫
 * @date 2023/4/21
 */
public class _6_ {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < nums3.length; k++) {
            for (int i = 0; i < nums4.length; i++) {
                int key = nums4[i] + nums3[k];
                Integer nums = map.get(key);
                if (nums == null) {
                    map.put(key, 1);
                } else {
                    map.put(key, ++nums);
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int i1 = nums1[i] + nums2[j];
                Integer integer = map.get(-i1);
                if (integer != null) {
                    count += integer;
                }
            }
        }
        return count;
    }
}
