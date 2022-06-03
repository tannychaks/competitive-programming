package striverSDEsheet.day13;

public class QueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);
        System.out.println("The peek of the queue before deleting any element " + q.peek());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.peek());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}

class Queue {
    int maxCapacity = 100000;
    int[] arr;
    int currSize;
    int front;
    int rear;

    Queue() {
        arr = new int[maxCapacity];
        currSize = 0;
        front = -1;
        rear = -1;
    }

    Queue(int maxCapacity) {
        this.maxCapacity = maxCapacity;

        arr = new int[maxCapacity];
        currSize = 0;
        front = -1;
        rear = -1;
    }

    public void push(int element) {
        if (currSize == maxCapacity) {
            System.out.println("Queue is full");
            System.exit(1);
        }

        if (rear == -1) {
            front = 0;
            rear = 0;
        } else
            rear = (rear + 1) % maxCapacity;

        arr[rear] = element;
        currSize++;
    }

    public int pop() {
        if (front == -1) {
            System.out.println("Queue is empty");
            System.exit(1);
        }

        int popped = arr[front];
        if (currSize == 1) {
            front = -1;
            rear = -1;
        } else
            front = (front + 1) % maxCapacity;
        currSize--;
        return popped;
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queeu is empty");
            System.exit(1);
        }

        return arr[front];
    }

    public int size() {
        return currSize;
    }
}