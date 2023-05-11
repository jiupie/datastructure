package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/12
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 70, 80, 90};
        System.out.println(binarySearch.binarySearch(0, nums));
        System.out.println(binarySearch.binarySearch(1, nums));
        System.out.println(binarySearch.binarySearch(70, nums));
        System.out.println(binarySearch.binarySearch(11, nums));
        System.out.println(binarySearch.binarySearch(9, nums));
    }

    //二分查询
    public int binarySearch(int num, int[] nums) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == num) {
                index = mid;
                break;
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return index;
    }

    //https://leetcode.cn/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
                if (left > right) {
                    index = mid;
                }
            } else {
                left = mid + 1;
                if (left > right) {
                    index = mid + 1;
                }
            }

        }
        return index;
    }
}
