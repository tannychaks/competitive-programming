package striverSDEsheet.day1;

public class BestStockBuySell {
    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
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
