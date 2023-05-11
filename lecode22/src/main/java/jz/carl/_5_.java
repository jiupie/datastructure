package jz.carl;

import java.util.HashMap;

/**
 * 滑动窗口
 *
 * @author 南顾北衫
 * @date 2023/4/17
 */
public class _5_ {
    public static void main(String[] args) {
        _5_ v = new _5_();
        System.out.println(v.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(v.lengthOfLongestSubstring("au"));
    }


    //不满足条件调右边  满足条件调左边
    //209. 长度最小的子数组 https://leetcode.cn/problems/minimum-size-subarray-sum/

    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //update 信息
            sum += nums[i];

            while (sum >= target) {
                //满足条件
                count = Math.min(count, i - slow + 1);
                //更新慢指针和结果值
                sum = sum - nums[slow++];
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }


    //3. 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/

    //不满足条件调右边  满足条件调左边
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int slow = 0;
        int count = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //更新值
            Integer integer = map.get(chars[i]);
            if (integer != null) {
                map.put(chars[i], ++integer);
            } else {
                map.put(chars[i], 1);
            }
            while (map.values().stream().filter(num -> num > 1).toArray().length > 0) {
                Integer integer1 = map.get(chars[slow]);
                map.put(chars[slow], --integer1);
                slow++;
            }
            count = Math.max(count, i - slow + 1);

        }

        return count;
    }


}


