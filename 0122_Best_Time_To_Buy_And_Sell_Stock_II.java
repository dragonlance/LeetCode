/*
        解题思路
    因为可以多次买卖人，所以只要后一个比前一个大，就假设之前买了，现在卖掉
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
