package general;

public class InterfaceLogic {
    public static void main(String[] args) {
        X x = new X();
        System.out.println(x.m1());
    }

}

class X implements A, B {
    @Override
    public int m1() {
        System.out.println("Hey");
        return 10;
    }
}

interface A {
    int m1();
}

interface B {
    int m1();
}