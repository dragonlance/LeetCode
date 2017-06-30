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

    //   解题思路
    // 1. 因为已经排序，每一次取最中间的数，生成一个node
    // 2. 然后左边区间的递归生成node，作为1中node的左孩子
    // 3. 同理如第二步，右边区间生成node，作为1中node的右孩子

    public  TreeNode sortedArrayToBST(int[] nums) {
        // 再写一个function, 可以针对特定range
        return sortedArrayToBSTInRange(nums, 0, nums.length - 1);
    }

    // 这种写法是当时自己写出来的
    public  TreeNode sortedArrayToBSTInRange(int[] nums, int from, int to) {

        TreeNode node = null;

        if (to == from) {
            node = new TreeNode(nums[from]);
        } else if (from < to) {
            // 题目只要求height balanced BST，并没有说当左右必须不对称时，优先让左边满
            int middle = (to + from + 1) / 2;   // 因为奇偶不一样，这样补1，让奇偶时都满足左边全满
            int middle = (to + from) / 2;       //直接这样写也行，就是不对称时，满足右边全满
            node = new TreeNode(nums[middle]);
            node.left = sortedArrayToBSTInRange(nums, from, middle - 1);
            node.right = sortedArrayToBSTInRange(nums, middle + 1, to);
        }
        return node;
    }

    // 这种写法更简洁
    public  TreeNode sortedArrayToBSTInRange2(int[] nums, int from, int to) {

        if (from > to) return null;

        int middle = (from + to) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBSTInRange(nums, from, middle - 1);
        node.right = sortedArrayToBSTInRange(nums, middle + 1, to);
        return node;
    }
}
