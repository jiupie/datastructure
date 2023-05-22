package jz.carl.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/5/22
 */
public class _5_ {
    public static void main(String[] args) {
        _5_ v = new _5_();
        List<String> list = v.letterCombinations("23");
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }

        HashMap<String, String> hashMap = new HashMap<>();
        char[] chars = digits.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case '2':
                    hashMap.put(String.valueOf(aChar), "abc");
                    break;
                case '3':
                    hashMap.put(String.valueOf(aChar), "def");
                    break;
                case '4':
                    hashMap.put(String.valueOf(aChar), "ghi");
                    break;
                case '5':
                    hashMap.put(String.valueOf(aChar), "jkl");
                    break;
                case '6':
                    hashMap.put(String.valueOf(aChar), "mno");
                    break;
                case '7':
                    hashMap.put(String.valueOf(aChar), "pqrs");
                    break;
                case '8':
                    hashMap.put(String.valueOf(aChar), "tuv");
                    break;
                case '9':
                    hashMap.put(String.valueOf(aChar), "wxyz");
                    break;
            }
        }

        char[] chars1 = digits.toCharArray();
        List<String> list = new ArrayList<>();

        for (char c : chars1) {
            String s = hashMap.get(String.valueOf(c));
            if (s != null) {
                list.add(s);
            }
        }
        if (list.size() == 0) {
            return new ArrayList<>();
        }
        recursion(list, chars1.length, 0);
        return resList;
    }

    List<Character> list = new ArrayList<>();
    List<String> resList = new ArrayList<>();

    //2 abc
    //3 def
    public void recursion(List<String> s, int k, int startIndex) {
        if (list.size() == k) {
            StringBuilder stringBuilder = new StringBuilder();
            list.forEach(stringBuilder::append);
            resList.add(stringBuilder.toString());
        }

        if(startIndex>=s.size()){
            return;
        }

        String str = s.get(startIndex);
        char[] s1 = str.toCharArray();
        for (int j = 0; j < s1.length; j++) {
            list.add(s1[j]);
            recursion(s, k, startIndex+1);
            list.remove(list.size() - 1);
        }
    }
}
