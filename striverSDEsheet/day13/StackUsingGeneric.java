package striverSDEsheet.day13;

public class StackUsingGeneric {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println(stack.isEmpty());

        stack.push(6);
        stack.push(3);
        stack.push(7);

        System.out.println(stack.size());

        System.out.println(stack.peek());

        stack.pop();

        System.out.println(stack.peek());

        System.out.println(stack.Search(14));
        System.out.println(stack.Search(6));

        stack.setCapacity(4);
        stack.push(12);
        stack.push(13);
        stack.push(14);

    }
}

interface Stackable<T> {
    void push(T val);

    void setCapacity(int x);

    T pop();

    T peek();

    boolean isEmpty();

    int size();

    int Search(Object o);
}

class MyStack<T> implements Stackable<T> {
    private MyStack<T> prev;
    private T val;
    private int maxCapacity = 100000;

    MyStack() {
    }

    MyStack(T val) {
        this.val = val;
    }

    MyStack(MyStack<T> prev, T val) {
        this.prev = prev;
        this.val = val;
    }

    @Override
    public void push(T val) {
        if (this.size() == maxCapacity)
            throw new IllegalArgumentException("Stack is Full.");
        this.prev = new MyStack<T>(this.prev, this.val);
        this.val = val;
    }

    @Override
    public T pop() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Stack is empty");
        T top = this.val;
        this.val = this.prev.val;
        this.prev = this.prev.prev;
        return top;
    }

    @Override
    public T peek() {
        return this.val;
    }

    @Override
    public boolean isEmpty() {
        return this.prev == null;
    }

    @Override
    public int size() {
        return this.isEmpty() ? 0 : 1 + this.prev.size();
    }

    @Override
    public int Search(Object o) {
        int count = 1;
        for (MyStack<T> stack = this; !stack.isEmpty(); stack = stack.prev) {
            if (stack.val.equals(o))
                return count;
            count++;
        }
        return -1;
    }

    @Override
    public void setCapacity(int x) {
        this.maxCapacity = x;

    }
}