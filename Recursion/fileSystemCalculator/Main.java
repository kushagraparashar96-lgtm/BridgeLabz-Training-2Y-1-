package Recursion.fileSystemCalculator;

import Recursion.fileSystemCalculator.model.FileNode;
import Recursion.fileSystemCalculator.service.SizeCalculatorService;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FileNode project = new FileNode("project");

        FileNode src = new FileNode("src");
        src.add(new FileNode("main.java", 100));
        src.add(new FileNode("utils.java", 50));

        FileNode docs = new FileNode("docs");
        docs.add(new FileNode("readme.txt", 10));
        FileNode guides = new FileNode("guides");
        guides.add(new FileNode("setup.pdf", 200));
        docs.add(guides);

        FileNode config = new FileNode("config.xml", 20);

        project.add(src);
        project.add(docs);
        project.add(config);

        SizeCalculatorService calculator = new SizeCalculatorService();

        System.out.println("Recursive Size: " + calculator.calculateSizeRecursive(project) + " KB");
        System.out.println("Iterative Size: " + calculator.calculateSizeIterative(project) + " KB");

        guides.add(project);
        System.out.println("Cycle-Safe Size: " + calculator.calculateSizeCycleSafe(project, new HashSet<>()) + " KB");
    }
}