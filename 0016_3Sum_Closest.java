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

// 另一种经典的求极值的写法
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {

        // 另一种常用的找极值的方法
        // 先用一个全局变量，存一个实际的初始值，而不是MAX_VALUE之类的
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 这一步可以优化去重
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) return sum;
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum < target) {
                    left++;
                    // 去重优化，但是无法从指标上提升
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > target) {
                    right--;
                    // 去重优化， 但是无法从指标上提升
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return closestSum;
    }
}
