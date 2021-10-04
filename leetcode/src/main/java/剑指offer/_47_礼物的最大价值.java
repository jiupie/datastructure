package 剑指offer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 * 解题方法：
 *  从最后一个元素开始
 *      不断的向前算
 */
public class _47_礼物的最大价值 {
    private static int r;
    private static int c;
    private static int arr[][];

    public static void main(String[] args) {
        int grid[][] = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue(grid));

    }


    public static int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        r = grid.length;
        c = grid[0].length;
        arr = new int[r][c];

        return maxValue2(grid, grid.length - 1, grid[0].length - 1);
    }



    public static int maxValue3(int[][] grid, int arr1, int arr2) {
        int down = 0;
        int right = 0;

        if (arr[arr1][arr2] > 0) {
            return arr[arr1][arr2];
        }

        //如果arr1-1>=0 arr2>=0 可以向下，或者向右
        if (arr1 - 1 >= 0 && arr2 - 1 >= 0) {
            down += maxValue2(grid, arr1 - 1, arr2);
            right += maxValue2(grid, arr1, arr2 - 1);
        } else if (arr1 - 1 < 0 && arr2 - 1 >= 0) {//只能向右
            right += maxValue2(grid, arr1, arr2 - 1);
        } else if (arr1 - 1 >= 0) {//只能向下
            down += maxValue2(grid, arr1 - 1, arr2);
        }
        arr[arr1][arr2] = grid[arr1][arr2] + Math.max(down, right);
        return arr[arr1][arr2];
    }

    /**
     * 记忆化搜索
     * @param grid
     * @param arr1
     * @param arr2
     * @return
     */
    public static int maxValue2(int[][] grid, int arr1, int arr2) {
        int down = 0;
        int right = 0;

        if (arr[arr1][arr2] > 0) {
            return arr[arr1][arr2];
        }
        //如果arr1-1>=0 arr2>=0 可以向下，或者向右
        if (arr1 - 1 >= 0 && arr2 - 1 >= 0) {
            down += maxValue2(grid, arr1 - 1, arr2);
            right += maxValue2(grid, arr1, arr2 - 1);
        } else if (arr1 - 1 < 0 && arr2 - 1 >= 0) {//只能向右
            right += maxValue2(grid, arr1, arr2 - 1);
        } else if (arr1 - 1 >= 0) {//只能向下
            down += maxValue2(grid, arr1 - 1, arr2);
        }
        arr[arr1][arr2] = grid[arr1][arr2] + Math.max(down, right);
        return arr[arr1][arr2];
    }

    /**
     * 纯递归
     * @param grid
     * @param arr1
     * @param arr2
     * @return
     */
    public static int maxValue1(int[][] grid, int arr1, int arr2) {
        int down = 0;
        int right = 0;

        //如果arr1-1>=0 arr2>=0 可以向下，或者向右
        if (arr1 - 1 >= 0 && arr2 - 1 >= 0) {
            down += maxValue2(grid, arr1 - 1, arr2);
            right += maxValue2(grid, arr1, arr2 - 1);
        } else if (arr1 - 1 < 0 && arr2 - 1 >= 0) {//只能向右
            right += maxValue2(grid, arr1, arr2 - 1);
        } else if (arr1 - 1 >= 0) {//只能向下
            down += maxValue2(grid, arr1 - 1, arr2);
        }

        return grid[arr1][arr2] + Math.max(down, right);
    }
}
