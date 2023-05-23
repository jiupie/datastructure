package jz.carl.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/5/18
 */
public class _2_ {
    public static void main(String[] args) {
        _2_ v = new _2_();
        List<List<Integer>> combine = v.combine(4, 2);
        System.out.println(combine);
    }
    public List<List<Integer>> combine(int n, int k) {
        backTracing(n, k, 1);
        return list;
    }

    List<Integer> res = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();

    public void backTracing(int n, int k, int startIndex) {
        if (res.size() == k) {
            List<Integer> collect = new ArrayList<>(res);
            list.add(collect);
            return;
        }

        //             [1,4]
        //    1      2      3   4
        //  2 3 4  3   4    4   null

        for (int i = startIndex; i <= n; i++) {
            res.add(i);
            backTracing(n, k, i + 1);
            res.remove(res.size() - 1);
        }
    }
}
