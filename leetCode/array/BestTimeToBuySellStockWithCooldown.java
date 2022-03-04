package leetCode.array;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * 
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 */
public class BestTimeToBuySellStockWithCooldown {
    public static void main(String[] args) {
        int[] prices = new int[] { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(prices));
    }

    /**
     * Time Complexity: O(N) --> N is length of the input price array
     * Space Complexity: O(1) --> Constant Space
     * 
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {

        if (prices.length < 1)
            return 0;
        int buy = -prices[0];
        int sell = 0, prevSell = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, prevSell - prices[i]);
            prevSell = sell;

            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
