package loveBabbar.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baloons {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  String[] arr = new String[n];
  for (int i = 0; i < n; i++) {
   arr[i] = sc.next();
  }
  System.out.println(findOddColor(arr, n));
  sc.close();
 }

 private static int findOddColor(String[] arr, int n) {
  Map<String, Integer> map = new HashMap<>();
  for (String s : arr) {
   if (map.containsKey(s)) {
    map.put(s, map.get(s) + 1);
   } else {
    map.put(s, 1);
   }
  }
  for (Map.Entry entry : map.entrySet()) {
   int val = (int) entry.getValue();
   if (val % 2 != 0) {

    return val;
   }
  }
  return 0;
 }
}
