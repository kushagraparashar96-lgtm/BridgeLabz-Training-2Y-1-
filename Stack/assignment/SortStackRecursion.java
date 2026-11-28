package Stack.assignment;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStackRecursion {

    public static void sortStack(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        sortedInsert(stack, top);
    }

    private static void sortedInsert(Deque<Integer> stack, int element) {
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        sortedInsert(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        sortStack(stack);
        System.out.println("Sorted Stack (Top to Bottom): " + stack); // [30, 18, 14, -3, -5]
    }
}