package jz.carl.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/5/23
 */
public class _4_ {

    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(k, n, 1);
        return resList;
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> resList = new ArrayList<>();
    int sum = 0;


    public void recursion(int k, int n, int startIndex) {
        if (list.size() == k) {
            if (sum == n) {
                resList.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            list.add(i);
            recursion(k, n, i + 1);
            Integer s = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            sum -= s;
        }
    }

}
