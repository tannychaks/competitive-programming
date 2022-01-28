package general;

import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(method(n));
    sc.close();
  }

  private static int method(int n) {
    return 0;
  }
}