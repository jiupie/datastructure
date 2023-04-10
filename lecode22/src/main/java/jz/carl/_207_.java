package jz.carl;

import java.util.*;

/**
 * @author 南顾北衫
 * @date 2023/4/6
 */
public class _207_ {
    public static void main(String[] args) {
        _207_ v = new _207_();
//        5 [[1,4],[2,4],[3,1],[3,2]]
        System.out.println(v.canFinish(5, new int[][]{
                {1, 4}, {2, 4}, {3, 1}, {3, 2}
        }));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || (prerequisites.length == 0 || prerequisites[0].length == 0) && numCourses > 0) {
            return true;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            for (int i = 0; i < prerequisite.length; i++) {
                Set<Integer> integer = map.get(prerequisite[i]);
                if (integer == null) {
                    integer = new HashSet<>();
                }
                if (i != 0) {
                    integer.add(prerequisite[i - 1]);
                }
                map.put(prerequisite[i], integer);
            }
        }

        int res = 0;

        Set<Map.Entry<Integer, Set<Integer>>> entries = map.entrySet();
        Set<Integer> forSet = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : entries) {
            Set<Integer> value = entry.getValue();
            if (value.size() == 0) {
                queue.add(entry.getKey());
                forSet.add(entry.getKey());
                res++;
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                Set<Integer> value = entry.getValue();
                Integer key = entry.getKey();
                if (!forSet.contains(key)) {
                    value.remove(poll);
                    if (value.size() == 0) {
                        queue.offer(key);
                        forSet.add(key);
                        res++;
                    }
                }
            }
        }


        return res >= numCourses || forSet.size() == map.size();
    }
}
