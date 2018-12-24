### Approach 1:Greedy贪心算法-先满足贪心度最小的孩子
```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
```
Time Complexity:O(mlog(m) + nlog(n) + m + n)\
Space Complexity:O(1)
