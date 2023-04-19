package jz.carl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/4/13
 */
public class Demo {
    public static void main(String[] args) {
        int[] a = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        Demo demo = new Demo();
        demo.insert(a);
        System.out.println(Arrays.toString(a));
    }

    private int[] tempArr;

    public void mergeAll(int[] nums) {
        tempArr = new int[nums.length >> 1];

    }




    public void insert(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        while (length > 1) {
            length = length >> 1;
            list.add(length);
        }

        for (Integer integer : list) {
            for (int i = integer; i < nums.length; i += integer) {
                int cur = i;
                int num = nums[i];
                while (cur > 0 && nums[cur - integer] > num) {
                    int temp = nums[cur];
                    nums[cur] = nums[cur - integer];
                    nums[cur - integer] = temp;
                    cur -= integer;
                }
                nums[cur] = num;
            }
        }

    }

    public void select(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int maxIndex = 0;
            for (int j = 1; j <= nums.length - 1 - i; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }


    }


}
