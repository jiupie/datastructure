package jz.jz9;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 *
 * @author 南顾北衫
 * @date 2022/11/3
 */
public class _38_ {
    public static void main(String[] args) {
        permutation("absdfa");
    }

    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> objects = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            objects.add(chars[i]);
        }
        Character[] characters = objects.toArray(new Character[0]);
        System.out.println(Arrays.toString(characters));



        return null;
    }
}
// a b s d f
//absdf asbdf adbsf afdsb
//