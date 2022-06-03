package striverSDEsheet.day13;

public class QueueUsingGeneric {
    public static void main(String[] args) {
        MyQueue<String> carWash = new MyQueue<>(4);
        carWash.enqueue("Toyota-Corolla"); // First added
        carWash.enqueue("Toyota-Sienna"); // Second
        carWash.enqueue("Ford-F150"); // Third
        carWash.enqueue("Doge-Charger"); // Fourth
        System.out.println(carWash.dequeue());
        System.out.println(carWash.size()); // First removed
        System.out.println(carWash.dequeue());// Second element removed
        System.out.println(carWash.peek());
    }
}

interface Queueable<T> {
    void enqueue(T val); // push

    T dequeue(); // pop

    T peek();

    int size();

    boolean isEmpty();

    boolean isFull();
}

class MyQueue<T> implements Queueable<T> {

    private T[] data;
    private int front = 0;
    private int rear;
    private int currSize = 0;

    @SuppressWarnings("unchecked")
    MyQueue() {
        data = (T[]) new Object[10]; // By default max capacity is set as 10
        rear = (data.length - 1);
    }

    @SuppressWarnings("unchecked")
    MyQueue(int maxCapacity) {
        data = (T[]) new Object[maxCapacity]; // By default max capacity is set as 10
        rear = (data.length - 1);
    }

    @Override
    public void enqueue(T val) {
        if (!this.isFull()) {
            rear = (rear + 1) % data.length;
            data[rear] = val;
            currSize++;
        } else
            throw new IllegalArgumentException("Queue is Full");

    }

    @Override
    public T dequeue() {
        if (!this.isEmpty()) {
            T dequeued = data[front];
            data[front] = null;
            front = (front + 1) % data.length;
            currSize--;
            return dequeued;
        } else
            return null;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : data[front];
    }

    @Override
    public int size() {
        return currSize;
    }

    @Override
    public boolean isEmpty() {
        return currSize == 0;
    }

    @Override
    public boolean isFull() {

        return currSize == data.length;
    }

}