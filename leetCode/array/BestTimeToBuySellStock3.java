package leetCode.array;

/**
 * 123. Best Time to Buy and Sell Stock III
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 */
public class BestTimeToBuySellStock3 {
    public static void main(String[] args) {
        int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(prices));
    }

    /**
     * 
     * Time Complexity: O(N) --> N is length of the input price array
     * Space Complexity: O(1) --> Constant Space
     * 
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int buy1st = -prices[0];
        int sell1st = buy1st + prices[0];
        int buy2nd = sell1st - prices[0];
        int sell2nd = buy2nd + prices[0];

        for (int i = 0; i < prices.length; i++) {
            buy1st = Math.max(buy1st, -prices[i]);

            sell1st = Math.max(sell1st, buy1st + prices[i]);

            buy2nd = Math.max(buy2nd, sell1st - prices[i]);

            sell2nd = Math.max(sell2nd, buy2nd + prices[i]);
        }
        return Math.max(sell1st, sell2nd);
    }
}
