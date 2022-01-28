package general;

public class OneLinerSwap {
 public static void main(String[] args) {
  int x = 5, y = 2;
  x += y - (y = x);
  System.out.println("X = " + x + "\nY = " + y);
 }
}
