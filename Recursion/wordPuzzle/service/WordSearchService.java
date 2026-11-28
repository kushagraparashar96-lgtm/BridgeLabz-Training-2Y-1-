package Recursion.wordPuzzle.service;

import Recursion.wordPuzzle.model.CellPosition;
import java.util.ArrayList;
import java.util.List;

public class WordSearchService {

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
    };

    public boolean wordExists(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == word.charAt(0) && backtrackExists(grid, word, r, c, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrackExists(char[][] grid, String word, int r, int c, int index, boolean[][] visited) {
        if (index == word.length() - 1) {
            return true;
        }

        visited[r][c] = true;

        for (int[] dir : DIRECTIONS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            if (isValid(grid, nextR, nextC) && !visited[nextR][nextC]
                    && grid[nextR][nextC] == word.charAt(index + 1)) {
                if (backtrackExists(grid, word, nextR, nextC, index + 1, visited)) {
                    return true;
                }
            }
        }

        visited[r][c] = false;
        return false;
    }

    public List<List<CellPosition>> findAllPaths(char[][] grid, String word) {
        List<List<CellPosition>> allPaths = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == word.charAt(0)) {
                    backtrackAll(grid, word, r, c, 0, visited, new ArrayList<>(), allPaths);
                }
            }
        }
        return allPaths;
    }

    private void backtrackAll(char[][] grid, String word, int r, int c, int index,
                              boolean[][] visited, List<CellPosition> currentPath,
                              List<List<CellPosition>> allPaths) {
        visited[r][c] = true;
        currentPath.add(new CellPosition(r, c, grid[r][c]));

        if (index == word.length() - 1) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int[] dir : DIRECTIONS) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if (isValid(grid, nextR, nextC) && !visited[nextR][nextC]
                        && grid[nextR][nextC] == word.charAt(index + 1)) {
                    backtrackAll(grid, word, nextR, nextC, index + 1, visited, currentPath, allPaths);
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited[r][c] = false;
    }

    private boolean isValid(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}