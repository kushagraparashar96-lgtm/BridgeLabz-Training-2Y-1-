package Stack.assignment;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStacks {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int x) {
        inStack.push(x);
    }

    public int dequeue() {
        shiftStacks();
        if (outStack.isEmpty()) throw new RuntimeException("Queue is empty");
        return outStack.pop();
    }

    public int peek() {
        shiftStacks();
        if (outStack.isEmpty()) throw new RuntimeException("Queue is empty");
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());       // 20
    }
}