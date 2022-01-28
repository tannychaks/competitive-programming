package general;

/**
 * Humpy likes to jump from one building to another. But he only jumps to next
 * higher building and stops when no higher building is available. Stamina
 * required for a journey is xor of all the heights on which humpy jumps until
 * he stops.
 * 
 * If heights are [1 2 4], and he starts from 1, goes to 2 stamina required is 
 * 1^2=3,then from 2 to 4. Stamina for the entire journey is 1^2^4=7. Find the 
 * maximum stamina required if can start his journey from any building.
 */
import java.util.*;

public class JumpyHumpy {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int N = sc.nextInt();
  int[] heights = new int[N];
  for (int i = 0; i < N; i++) {
   heights[i] = sc.nextInt();
  }
  System.out.println(calculateMaxHeight(heights, N));
  sc.close();
 }

 private static int calculateMaxHeight(int[] heights, int n) {
  List<Integer> tempList = new ArrayList<>(Collections.nCopies(n, 0));
  Stack<Integer> stack = new Stack<>();
  stack.push(0);

  for (int i = 1; i < n; i++) {

   while (!stack.empty() && heights[i] > heights[stack.peek()]) {
    tempList.set(stack.peek(), i);
    stack.pop();
   }

   stack.push(i);
  }
  System.out.println("TempList : " + tempList.toString());
  System.out.println("Stack : " + stack.toString());
  while (!stack.empty()) {
   tempList.set(stack.peek(), -1);
   stack.pop();
  }
  List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 0));
  int ans = 0;
  for (int i = n - 1; i >= 0; i--) {

   if (tempList.get(i) == -1) {
    dp.set(i, heights[i]);
    ans = Math.max(ans, dp.get(i));
    continue;
   }

   dp.set(i, heights[i] ^ dp.get(tempList.get(i)));

   ans = Math.max(ans, dp.get(i));
  }
  System.out.println("Final list : " + dp.toString());
  return ans;
 }

 /** only for contiguous building */
 private static int calculateMaxHeightAlt(int[] heights, int n) {
  int tempMax = heights[n - 1];
  int finalMax = tempMax;
  for (int i = (n - 1); i > 0; i--) {
   if (heights[i - 1] > heights[i]) {
    tempMax = heights[i - 1];
   } else {
    tempMax = heights[i - 1] ^ tempMax;
   }
   finalMax = Math.max(finalMax, tempMax);
  }
  return finalMax;
 }
}
