package leetCode.array;

/**
 * 122. Best Time to Buy and Sell Stock II
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 * 
 * Discussion :
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/1569081/
 */
public class BestTimeToBuySellStock2 {
    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    /**
     * Time Complexity: O(N) --> N is length of the input price array
     * Space Complexity: O(1) --> Constant Space
     * 
     * 
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
