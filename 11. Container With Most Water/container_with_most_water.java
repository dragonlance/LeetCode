/**
 * Created by pli on 6/11/16.
 */
public class container_with_most_water {
    public static void main(String[] args) {
        container_with_most_water test = new container_with_most_water();
        System.out.print(test.maxArea());
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] > height[right]) { //核心思想,两边往中间夹,谁小谁往里移动,大的保留
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
