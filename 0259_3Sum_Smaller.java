/*
    刷题笔记
    1. 这一题是让求find the number of index triplets i, j, k， 即是index的组合的个数，即是允许有重复
*/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 3) return count;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // if (i > 0 && nums[i] == nums[i - 1]) continue; // 不需要去重

            int max = target - nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left  < right) {
                if (nums[left] + nums[right] < max) {
                    count += right - left;

                    left++;
                    // right = nums.length - 1; // left指针右移，总和要想保持不变，right指针一定需要左移，所以不需要把right复原

                    // 不需要去重
                    // while (left < right && nums[left] == nums[left - 1]) {
                    //     left++;
                    // }

                } else {
                    right--;

                    // 不需要去重
                    // while (left < right && nums[right] == nums[right + 1]) {
                    //     right--;
                    // }
                }
            }
        }
        return count;
    }
}
