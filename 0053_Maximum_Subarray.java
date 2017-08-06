public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length]; // dp[i] means max subarray ending with index i
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) { // 如果以上一个index结尾的最大值为正数，则与上一个连起来，算作当前的最大值
                dp[i] = dp[i - 1] + nums[i];
            } else { // 如果以上一个index结尾的最大值为负数，则另起炉灶，从自己当前index算起，算作当前的最大值
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
