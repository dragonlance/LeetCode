import java.util.HashMap;
import java.util.Map;

/**
 * Created by pli on 6/2/16.
 */
public class two_sum {

    public class Solution {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target -nums[i]), i};
                } else {
                    map.put(nums[i], i);
                }
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static void main(String[] args) {

    }

}