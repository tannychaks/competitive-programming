package striverSDEsheet.day13;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
    public static void main(String[] args) {
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);

        System.out.println("current size: " + Stack.size());
        System.out.println(Stack.peek());
        Stack.pop();
        System.out.println(Stack.peek());
        Stack.pop();
        System.out.println(Stack.peek());

        System.out.println("current size: " + Stack.size());

    }

    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        static int currSize = 0;

        Stack() {
        };

        static void push(int x) {
            currSize++;

            // push x first in empty q2
            q2.add(x);

            // transfer q1 to q2 element by element
            while (!q1.isEmpty())
                q2.add(q1.poll());

            // swap q1 and q2
            Queue<Integer> tempQ = q1;
            q1 = q2;
            q2 = tempQ;
        }

        static int pop() {
            if (q1.isEmpty())
                throw new IllegalArgumentException("Stack is empty");
            else {
                int popped = q1.poll();
                currSize--;
                return popped;
            }
        }

        static int size() {
            return currSize;
        }

        static int peek() {
            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }
    }
}
