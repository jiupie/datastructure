package jz.carl.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/5/23
 */
public class _8_ {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(candidates, target, 0, 0);
        return resList;
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> resList = new ArrayList<>();

    public void recursion(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            resList.add(new ArrayList<>(list));
            return;
        }


        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            recursion(candidates, target, sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
        }

    }
}
