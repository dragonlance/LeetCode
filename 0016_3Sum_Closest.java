public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int closestSum = 0;              // 最接近target的sum
        int minDiff = Integer.MAX_VALUE; // 最小偏差

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[left] + nums[right] + nums[i];
                int diff = Math.abs(target - sum);

                if (diff == 0) return sum; // 如果找到target，直接返回，不算了

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < target) { // 如果比target小/大，向target逼近
                    left++;
                } else if (sum > target) {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
