package leetCode.array;

/**
 * 
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day, and an integer fee representing a transaction fee.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like, but you need to pay the transaction fee for each
 * transaction.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 */
public class BestTimeToBuySellStockWithTxnFee {
    public static void main(String[] args) {
        int[] prices = new int[] { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    /**
     * Time Complexity: O(N) --> N is length of the input price array
     * Space Complexity: O(1) --> Constant Space
     * 
     * @param prices
     * @param fee
     * @return
     */
    private static int maxProfit(int[] prices, int fee) {

        if (prices.length < 1)
            return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, sell - prices[i]);

            sell = Math.max(sell, buy + prices[i] - fee);
        }
        return sell;
    }
}
