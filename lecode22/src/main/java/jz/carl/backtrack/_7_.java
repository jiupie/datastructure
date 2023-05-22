package jz.carl.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/5/22
 */
public class _7_ {
    public static void main(String[] args) {
        _7_ v = new _7_();
        int[] s = {2, 3, 6, 7};
        System.out.println(v.combinationSum(s, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(candidates, target, 0);
        return resList;
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> resList = new ArrayList<>();
    int sum = 0;

    public void recursion(int[] candidates, int target, int start) {
        if (sum == target) {
            resList.add(new ArrayList<>(list));
            return;
        }

//        if(sum>target){
//            return;
//        }

        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                sum -= candidates[i];
                break;
            }
            list.add(candidates[i]);
            recursion(candidates, target, start);
            start++;
            int index = list.size() - 1;
            sum -= list.get(index);
            list.remove(index);
        }
    }
}
