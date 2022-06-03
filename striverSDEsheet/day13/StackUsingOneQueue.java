package striverSDEsheet.day13;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}

class MyStack1 {
    Queue<Integer> q = new LinkedList<>();

    public MyStack1() {

    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++)
            q.add(q.remove());

    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}