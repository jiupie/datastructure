package jz.carl.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 南顾北衫
 * @date 2023/4/20
 */
public class _3_ {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> setStandAlone = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                setStandAlone.add(i);
            }
        }

        return setStandAlone.stream().mapToInt(num -> num).toArray();
    }
}
