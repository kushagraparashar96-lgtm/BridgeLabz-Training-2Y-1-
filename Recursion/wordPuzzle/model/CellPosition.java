package Recursion.wordPuzzle.model;

public class CellPosition {
    private final int row;
    private final int col;
    private final char letter;

    public CellPosition(int row, int col, char letter) {
        this.row = row;
        this.col = col;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + "):" + letter;
    }
}