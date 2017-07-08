/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        // 一开始，沿着斜下方，一个一个的压入栈
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        // 出栈，同时把当前节点的right全压入栈
        // 一共有2种情况
        // 第一种，如果当前节点是左叶子节点，则pushAll()进去什么也不执行
        // 第二种，如果当前节点是中间父节点，则pushAll()把所有右孩子压入栈

        // 从第三次开始，右节点就可以接着出栈了
        TreeNode top = stack.pop();
        pushAll(top.right);
        return top.val;
    }
    // 这种方法，next的时间复杂度并不是O(1),但是不知道算不算平均O(1)

    // pushAll沿着左下方压栈
    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

public class BSTIterator2 {

    private List<TreeNode> list = new ArrayList<>();
    private int index = 0;

    public BSTIterator(TreeNode root) {
       addToList(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = list.get(index);
        index++;
        return node.val;
    }

    // 一开始先按照in-order中序遍历，把所有的节点存进一个数组里(数组用ArrayList,有助于后边按照index取值)
    // 这时数组里存的值，已经是从小到大存好的，只需维护一个index取值就行了
    private void addToList(TreeNode root) {
        if (root == null) return;
        addToList(root.left);
        list.add(root);
        addToList(root.right);
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
