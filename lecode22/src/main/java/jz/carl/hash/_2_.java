package jz.carl.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 南顾北衫
 * @date 2023/4/20
 */
public class _2_ {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer integer = smap.get(c);
            if (integer == null) {
                smap.put(c, 1);
            } else {
                smap.put(c, ++integer);
            }
        }

        for (char c : t.toCharArray()) {
            Integer integer = tmap.get(c);
            if (integer == null) {
                tmap.put(c, 1);
            } else {
                tmap.put(c, ++integer);
            }
        }

        boolean isAna = true;
        HashMap<Character, Integer> map1 = smap.size() > tmap.size() ? smap : tmap;
        HashMap<Character, Integer> map2 = map1 == smap ? tmap : smap;
        Set<Map.Entry<Character, Integer>> entries = map1.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer integer = map2.get(entry.getKey());
            if (!entry.getValue().equals(integer)) {
                isAna = false;
                break;
            }
        }

        return isAna;
    }

    public boolean isAnagram1(String s, String t) {
        int[] alphaArr = new int[26];

        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            alphaArr[sArr[i] - 'a'] = alphaArr[sArr[i] - 'a'] + 1;
        }

        char[] tArr = t.toCharArray();
        for (int i = 0; i < tArr.length; i++) {
            alphaArr[tArr[i] - 'a'] = alphaArr[tArr[i] - 'a'] - 1;
        }

        for (int i : alphaArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
