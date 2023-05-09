package com.layout;

/*
 * This class is to create a board layout for the game of tic-tac-toe.
 * It will have a 3x3 dimensions and each cell is identified by coordinates.
 */
public class Board {

    // This instance variable is for the board layout
    private char[][] layout;

    /**
     * Non-parameterized Constructor:
     * This will instantiate a Board object with 3x3 dimensions.
     */
    public Board() {
        layout = new char[3][3];
    }

    /**
     * Normal Method:
     * This method returns the number of rows in the board.
     *
     * @return
     */
    public int getRowSize() {
        return layout.length;
    }

    /**
     * Normal Method:
     * This method takes in an integer for the row index and then return the size of column (or number of elements in row).
     * If the size is less than 0 or greater than the index size of the row, then it will return -1.
     *
     * @param row
     * @return
     */
    public int getColumnSize(int row) {

        if (row < 0 || row > (getRowSize() - 1)) {
            System.out.println("Input is out of bounds");
            return -1;
        } else
            return layout[row].length;

    }

    /**
     * Normal Method:
     * This method asks for the row and column indexes and then sets the value as 'X'.
     *
     * @param row
     * @param column
     */
    public void setX(int row, int column) {
        layout[row][column] = 'X';
    }

    /**
     * Normal Method:
     * This method asks for the row and column indexes and then sets the value as 'O'.
     *
     * @param row
     * @param column
     */
    public void setO(int row, int column) {
        layout[row][column] = 'O';
    }
}
