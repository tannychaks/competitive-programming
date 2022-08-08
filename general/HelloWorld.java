package general;

public class HelloWorld {
  public static void main(String[] args) {
    String s = "Tanny";
    String t = "Tanny";
    String r = s;
    String p = new String("Tanny");
    System.out.println(s == t);
    System.out.println(s == r);
    System.out.println(s == p);
    System.out.println(s.equals(t));
    System.out.println(s.equals(r));
    System.out.println(s.equals(p));
  }
}