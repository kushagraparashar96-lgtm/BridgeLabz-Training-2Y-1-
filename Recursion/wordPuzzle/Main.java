package Recursion.wordPuzzle;

import Recursion.wordPuzzle.model.CellPosition;
import Recursion.wordPuzzle.service.WordSearchService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[][] grid = {
                {'C', 'A', 'T', 'S'},
                {'O', 'R', 'E', 'A'},
                {'D', 'E', 'A', 'M'},
                {'E', 'L', 'L', 'S'}
        };
        String target = "DREAM";

        WordSearchService service = new WordSearchService();

        System.out.println("Target '" + target + "' exists: " + service.wordExists(grid, target));

        List<List<CellPosition>> allPaths = service.findAllPaths(grid, target);
        System.out.println("Total paths found: " + allPaths.size());
        for (int i = 0; i < allPaths.size(); i++) {
            System.out.println("Path " + (i + 1) + ": " + allPaths.get(i));
        }
    }
}