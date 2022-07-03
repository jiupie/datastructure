package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/6/26
 */
public class _04_二维数组中的查找 {
    public static void main(String[] args) {
        int[][] s = new int[2][4];
        s[0] = new int[]{1, 2, 3, 4};
        s[1] = new int[]{2, 3, 4, 5};
        System.out.println(findNumberIn2DArray(s, 15));
    }


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //一维数组长度
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            //二维数组长度
            int length1 = matrix[i].length;
            for (int j = 0; j < length1; j++) {
                if (matrix[i][j] < target) {

                } else if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //一维数组长度
        int length = matrix.length;
        //二维数组长度
        int length1 = matrix[0].length;



        return false;
    }
}
