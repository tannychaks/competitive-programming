package loveBabbar.array;

import java.util.Scanner;

public class BestTimeToBuyStock {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  int[] prices = new int[N];
  for (int i = 0; i < N; i++)
   prices[i] = sc.nextInt();
  System.out.println(maxProfit(prices));
  sc.close();
 }

 private static int maxProfit(int[] prices) {
  if (prices.length == 0)
   return 0;
  int profit = Integer.MIN_VALUE;
  int buy = prices[0];
  for (int i = 1; i < prices.length; i++) {
   if (prices[i] < buy)
    buy = prices[i];
   profit = Math.max(profit, prices[i] - buy);
  }
  return Math.max(profit, 0);
 }
}
