package striverSDEsheet.day8;

public class MinNumberCoinExchangeGreedy {
    public static void main(String[] args) {
        int v = 11;
        int[] coins = new int[] { 9, 6, 5, 1 };
        int m = 4;
        int ans = minCoins(coins, m, v);
        System.out.println(ans);
    }

    /**
     * The time complexity of the above solution is O(mV).
     * 
     * Approach: dynamic Programming. Not a greedy solution
     * 
     * @param coins
     * @param m
     * @param V
     * @return
     */
    private static int minCoins(int[] coins, int m, int V) {

        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;

                }

        }

        if (table[V] == Integer.MAX_VALUE)
            return -1;

        return table[V];
    }
}
