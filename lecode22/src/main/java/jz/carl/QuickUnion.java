package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class QuickUnion {

    public int find(int[] nums, int v) {
        int num = nums[v];
        while (num != nums[num]) {
            num = nums[num];
        }
        return num;
    }

    public void union(int[] nums, int v1, int v2) {
        int v1Parent = find(nums, v1);
        int v2Parent = find(nums, v2);
        if (v1Parent == v2Parent) {
            return;
        }
        nums[v1] = v2Parent;
    }
}
