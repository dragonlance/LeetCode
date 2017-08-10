public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i : prices) {
            min = Math.min(i, min);//把目前出现过的最小值存下来
            profit = Math.max(i - min, profit);//然后用目前出现的所有值，减去目前的最小值
        }
        return profit;
    }
}
