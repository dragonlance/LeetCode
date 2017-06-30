/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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

    // 解题思路
    // 1. 因为链表不像数组，能直接取下标，所以需要想办法拿到中间节点
    // 2. 这里用快慢指针的方法，拿到中间节点
    // 3. 从开头到slow节点，递归给左孩子。从slow.next到结尾，递归给右孩子

    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTInRange(head, null);
    }

    public TreeNode sortedListToBSTInRange(ListNode from, ListNode to) {

        if (from == to) return null;

        ListNode fast = from;
        ListNode slow = from;

        // 快慢指针的边界判断写法，需要熟练
        while (fast != to && fast.next != to) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode middle = new TreeNode(slow.val);
        middle.left = sortedListToBSTInRange(from, slow);
        middle.right = sortedListToBSTInRange(slow.next, to);

        return middle;
    }
}
