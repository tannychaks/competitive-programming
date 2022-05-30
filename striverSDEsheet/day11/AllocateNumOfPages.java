package striverSDEsheet.day11;

import java.util.ArrayList;

public class AllocateNumOfPages {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(10);
        A.add(20);
        A.add(30);
        A.add(40);

        // A.add(12);
        // A.add(34);
        // A.add(67);
        // A.add(90);
        int B = 2;

        int book = books(A, B);

        System.out.println(book);
    }

    private static int books(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (n < B)
            return -1;
        int res = -1;
        int low = A.get(0), high = 0;
        for (int a : A) {
            low = Math.min(low, a);
            high += a;
        }
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (isValid(A, mid, B)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return res;
    }

    private static boolean isValid(ArrayList<Integer> A, int pages, int b) {
        int cnt = 0;
        int sum = 0;
        for (int a : A) {
            if (sum + a > pages) {
                cnt++;
                sum = a;
                if (sum > pages)
                    return false;
            } else
                sum += a;
        }
        if (cnt < b)
            return true;
        return false;
    }
}
