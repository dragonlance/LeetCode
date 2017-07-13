/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 *  解题思路
 *  1. 这本身就是一个BST
 *  2. 找最近的公共父节点
 *  3. 从root节点往下找，如果是一个更高／更远的父节点，那么p, q两个节点一定是同时在它左边或者同时在它右边
 *  4. until找到不满足条件3，说明p,q两个节点开始分叉了，那么从分叉那个节点开始，就是要找的公共父节点
 *  5. 都大于／都小于，都说明还不是最近的公共父节点。当有相等的情况发生时，正好这个条件不满足，返回此节点
 */

 // iterative
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((p.val - root.val) * (q.val - root.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}

// iterative 2
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q） {

    while (true) {
        if (p.val < root.val && q.val < root.val) {
            root = root.left;
        } else if (p.val > root.val && q.val > root.val) {
            root = root.right;
        } else {
            return root;
        }
    }

    /*
    这种写法是错的
    原因：p,q两个节点，随着root节点往下走，有可能这一次是都在root节点的左边，下一次又变成了都在root节点的右边。这种写法，是先过一遍左，再过一遍右，加入了不必要的先左后右的强制顺序
    while (p.val < root.val && q.val < root.val) {
	    root = root.left;
    }
    while (p.val > root.val && q.val > root.val) {
	    root = root.right;
    }
    return root;
    */
    }
}

// recursive
public class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) > 0) {
            root = lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
        }
        return root;
    }
}

// recursive 2
public class Solution4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
