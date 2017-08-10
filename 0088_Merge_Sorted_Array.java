public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1; //分别取两个数组里最大的值，放在总长度index最右边
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while (j >= 0) { //剩下有些没有被合并进去，如果在arr1内部的话，没关系。如果在arr2的话，要merge进去
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
