package leetCode.array;

/**
 * 
 * 121. Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * Discussion:
 * 
 * 1.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/1494171/most-general-solutions-for-the-series-of-stock-problems
 * 
 * 2.https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/1569081/
 */
public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    /**
     * Time Complexity: O(N) --> N is length of the input price array
     * Space Complexity: O(1) --> Constant Space
     * 
     * Similar to Kadane's algorithm
     * 
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int profit = Integer.MIN_VALUE;

        int buy = prices[0];
        for (int price : prices) {
            if (price < buy)
                buy = price;
            profit = Math.max(profit, price - buy);
        }
        return Math.max(profit, 0);
    }
}
