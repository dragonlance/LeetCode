/*

    解题思路
    2个核心递推公式：
    1: 5个节点组成BST，分别有5个大情况，就是分别以1，2,...5为root节点的情况
    2: 当上一步中以3为root节点时，大问题可以分解为2个子问题，就是3左边2个节点可以组成几个BST， 以及3右边2个节点可以组成几个BST
    假设dp[n]就是n个节点可以组成的BST数
    假设f(i, n)是以第i个节点为root节点是，n个节点可以组成的BST数
    那么dp[n] = f(1, n) + f(2, n) + ... + f(n, n)
    而f(i, n) ＝ dp(i - 1) * dp(n - i)

*/

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        // 外层循环，纯粹是为了求dp[n]而从dp[2]网上堆数据的
        for (int i = 2; i <= n; i++) {
            int tmp = 0;

            // 内层循环，分别以j为root的情况数
            for (int j = 1; j <= i; j++) {
                tmp = dp[j - 1] * dp[i - j];
                dp[i] += tmp;
            }
        }

        return dp[n];
    }
}
