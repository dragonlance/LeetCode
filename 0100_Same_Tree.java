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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果都为null, 相等
        if (p == null && q == null) return true;

        // 如果能走到这，说明不都为null，那么只要有任何一个为null，就不对称
        if (p == null || q == null) return false;

        // 如果能走到这，说明都不为null，就可以大胆的访问val(不怕null pointer)
        if (p.val != q.val) return false;

        // 如果两个当前值相等，递归判断下面的子节点
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
