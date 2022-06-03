package striverSDEsheet.day13;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

class MyQueue1 {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue1() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (!output.isEmpty())
            return output.pop();
        else {
            while (!input.empty()) {
                output.push(input.pop());
            }

            return output.pop();
        }
    }

    public int peek() {
        if (!output.isEmpty())
            return output.peek();
        else {
            while (!input.empty()) {
                output.push(input.pop());
            }
            return output.peek();
        }

    }

    public boolean empty() {
        return (output.size() + input.size()) == 0;
    }
}