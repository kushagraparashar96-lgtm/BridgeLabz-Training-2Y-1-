package Stack.Basics;

import java.util.Stack;

public class StackOps2 {
    int top;
    int capacity;
    int[] arr;

    void Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
        System.out.println(data);
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int data = arr[top--];
        System.out.println(data);
        return data;
    }


        public static void main(String[] args) {
            // Size 2 ka stack banaya
            Stack s = new Stack();

            System.out.println("--- PUSHING ELEMENTS ---");
            s.push(10);
            s.push(20);
            s.push(30);

            System.out.println("\n--- POPPING ELEMENTS ---");
            s.pop();
            s.pop();
            s.pop();
        }
    }
