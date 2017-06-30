/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {


    public  TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBSTInRange(nums, 0, nums.length - 1);

    }

    public  TreeNode sortedArrayToBSTInRange(int[] nums, int from, int to) {

        if (from > to) return null;

        int middle = (from + to) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBSTInRange(nums, from, middle - 1);
        node.right = sortedArrayToBSTInRange(nums, middle + 1, to);
        return node;

    }

    public  TreeNode sortedArrayToBSTInRange2(int[] nums, int from, int to) {

        TreeNode node = null;

        if (to == from) {
            node = new TreeNode(nums[from]);
        } else if (from < to) {
            int middle = (to + from + 1) / 2;
            node = new TreeNode(nums[middle]);
            node.left = sortedArrayToBSTInRange(nums, from, middle - 1);
            node.right = sortedArrayToBSTInRange(nums, middle + 1, to);
        }

        return node;

    }
}
