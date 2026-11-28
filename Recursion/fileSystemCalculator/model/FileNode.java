package Recursion.fileSystemCalculator.model;

import java.util.ArrayList;
import java.util.List;

public class FileNode {
    private String name;
    private boolean isDirectory;
    private int size;
    private List<FileNode> children;

    public FileNode(String name, int size) {
        this.name = name;
        this.isDirectory = false;
        this.size = size;
    }

    public FileNode(String name) {
        this.name = name;
        this.isDirectory = true;
        this.size = 0;
        this.children = new ArrayList<>();
    }

    public void add(FileNode child) {
        if (this.isDirectory) {
            this.children.add(child);
        }
    }

    public String getName() { return name; }
    public boolean isDirectory() { return isDirectory; }
    public int getSize() { return size; }
    public List<FileNode> getChildren() { return children; }
}