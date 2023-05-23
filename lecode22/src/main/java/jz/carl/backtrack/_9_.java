package jz.carl.backtrack;

import java.util.ArrayList;
import java.util.List;

public class _9_ {
    public static void main(String[] args) {
        _9_ v = new _9_();
        v.recursion("aab", 0);
        System.out.println(v.resList);
    }

    public List<List<String>> partition(String s) {
        recursion(s, 0);
        return resList;
    }

    List<String> list = new ArrayList<>();
    List<List<String>> resList = new ArrayList<>();

    public void recursion(String s, int start) {
        if (start >= s.length()) {
            resList.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i+1);
            if (!isPartition(substring)) {
                continue;
            }
            list.add(substring);
            recursion(s, i + 1);
            list.remove(list.size() - 1);
        }


    }

    public boolean isPartition(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        boolean isS = true;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                isS = false;
                break;
            }
            left++;
            right--;
        }
        return isS;
    }
}
