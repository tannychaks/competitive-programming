package striverSDEsheet.day13;

public class StackUsingArray {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}

class Stack {

    int size = 10000;
    int arr[] = new int[size];
    int top = -1;

    Stack() {
    };

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        int x = arr[top];
        top--;
        return x;
    }

    int top() {
        return arr[top];
    }

    int size() {
        return top + 1;
    }

}