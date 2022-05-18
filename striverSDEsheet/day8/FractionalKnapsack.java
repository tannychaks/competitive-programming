package striverSDEsheet.day8;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class Item {
        int value;
        int weight;

        Item() {

        }

        Item(int value, int weight) {
            this.weight = weight;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        Item[] arr = new Item[] { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
        int w = 50, n = 3;

        double ans = fractionalKnapsack(w, arr, n);

        System.out.println(ans);
    }

    private static double fractionalKnapsack(int w, Item[] arr, int n) {

        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double ratio1 = (double) o1.value / (double) o1.weight;
                double ratio2 = (double) o2.value / (double) o2.weight;

                if (ratio1 < ratio2)
                    return 1;
                else if (ratio1 > ratio2)
                    return -1;
                else
                    return 0;
            }
        });
        // Arrays.stream(arr).forEach(item -> {
        // System.out.print(item.value + " " + item.weight);
        // System.out.println();
        // });
        int currWeight = 0;
        double maxProfit = 0.0;

        for (Item item : arr) {

            if (currWeight + item.weight <= w) {
                currWeight += item.weight;
                maxProfit += item.value;
            } else {
                int remain = w - currWeight;
                maxProfit += ((double) item.value / (double) item.weight) * (double) remain;
                break;
            }
        }
        return maxProfit;
    }
}
