package Recursion.fileSystemCalculator.service;

import Recursion.fileSystemCalculator.model.FileNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class SizeCalculatorService {

    public int calculateSizeRecursive(FileNode item) {
        if (!item.isDirectory()) {
            return item.getSize();
        }
        int totalSize = 0;
        for (FileNode child : item.getChildren()) {
            totalSize += calculateSizeRecursive(child);
        }
        return totalSize;
    }

    public int calculateSizeIterative(FileNode root) {
        int totalSize = 0;
        Deque<FileNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            FileNode current = stack.pop();
            if (!current.isDirectory()) {
                totalSize += current.getSize();
            } else {
                for (FileNode child : current.getChildren()) {
                    stack.push(child);
                }
            }
        }
        return totalSize;
    }

    public int calculateSizeCycleSafe(FileNode item, Set<FileNode> visited) {
        if (visited.contains(item)) {
            return 0;
        }
        visited.add(item);

        if (!item.isDirectory()) {
            return item.getSize();
        }

        int totalSize = 0;
        for (FileNode child : item.getChildren()) {
            totalSize += calculateSizeCycleSafe(child, visited);
        }
        return totalSize;
    }
}