package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class QuickUnion {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion();
//        int[][] a = {{0, 1}, {0, 2}, {1, 2}};
        int[][] a = {{0, 4}, {1, 6}, {2, 9}, {4, 7}, {0, 6}, {6, 9}, {4, 8}, {1, 4}, {4, 9}, {1, 8}, {2, 8}, {3, 4}, {0, 9}};
        System.out.println(quickUnion.makeConnected(10, a));
    }

    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length){
            return -1;
        }
        QuickUnion u=new QuickUnion();

        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        int count = n-1;
        for (int i = 0; i < connections.length; i++) {
            int i1 = connections[i][0];
            int i2 = connections[i][1];
            int i3 = u.find(nums, i1);
            int i4 = u.find(nums, i2);
            if (i3 == i4) {
                // count++;
            } else {
                u.union(nums, i1, i2);
                count--;
            }
        }
        return count;
    }

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
        nums[v1Parent] = v2Parent;
    }
}
