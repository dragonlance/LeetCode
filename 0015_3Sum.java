public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();//相当于是二维数组，LinkedList适合动态添加
        if (nums == null || nums.length < 3) return list;//如不哦不够3个，不用排序了，直接返回空Array
        Arrays.sort(nums);//很重要的一步，因为有了排序，所以后边可以通过判断临近位是否相等排除重复项
        int target = 0; // 虽然这一题让求的和是0，但是可以扩展为任何target

        for (int i = 0; i < nums.length; i ++) {//外围第一层循环

            if (i != 0 && nums[i] == nums[i - 1]) continue;//跳过重复项，来到重复项的最后一项

            int sum = target - nums[i];//求出其他两个数字所需要的和，然后在内循环中，寻找和为这个sum的两个数
            int left = i + 1;//采取的策略是，用左右两边两个指针往中间夹
            int right = nums.length - 1;//和大了，就又指针左移一位；和小了，就左指针右移一位

            while (right > left) {
                if (nums[left] + nums[right] == sum) {

                    List<Integer> subList = Arrays.asList(nums[i], nums[left], nums[right]);//这种语法：Array转List

                    /* 想不起来，还可以老老实实的这样写
                    List<Integer> subList = new LinkedList<>();
                    subList.add(nums[i]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    */
                    
                    list.add(subList);//往大List里添加一个子List

                    while (left < right && nums[left] == nums[left + 1]) left++;//去重
                    while (left < right && nums[right] == nums[right - 1]) right--;//去重
                    // 上两行，只是把left和right都移动到了最后一个重复项内

                    // 所以需要下面两行，再往前走一步，变成不重复的最新项
                    left++;
                    right--; // 因为left和right都已经用过了，所以都进入新的一步。如果只改变一边，两者的和势必不再等于sum

                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
