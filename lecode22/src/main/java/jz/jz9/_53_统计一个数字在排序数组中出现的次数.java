package jz.jz9;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * @author 南顾北衫
 */
public class _53_统计一个数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] ints = {5,7,7,8,8,10};

        int search = search(ints, 10);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        if(nums==null|| nums.length==0){
            return 0;
        }
        int mid = nums.length / 2;

        int left = mid;
        int right = mid + 1;
        int count = 0;
        while (left >= 0) {
            if (target == nums[left]) {
                count++;
            } else if (target > nums[left]) {
                break;
            }
            left--;
        }

        while (right < nums.length) {
            if (target == nums[right]) {
                count++;
            } else if (target < nums[right]) {
                break;
            }
            right++;
        }

        return count;
    }


}
