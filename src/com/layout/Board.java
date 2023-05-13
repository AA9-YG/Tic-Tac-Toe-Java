package com.layout;

import java.lang.reflect.Array;

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

    public void displayBoard() {
        for(int i = 0; i < getRowSize(); i++) {
            System.out.print("|");
            for(int j = 0; j < getRowSize(); j++) {
                System.out.print(" " + getValue(i, j) + " |");
            }
            System.out.println();
        }
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
     * This method asks for the row and column indexes and then returns the value.
     *
     * @param row
     * @param column
     * @return
     */
    public char getValue(int row, int column) {
        return layout[row][column];
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

    /**
     * Normal method:
     * This method will check if the board is full with values. If so, then it will return true.
     * This will help decide whether the game has ended in a tie.
     * @return
     */
    public boolean isFull() {
        int counter = 0;

        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                if (((int) layout[i][j]) != 0)
                    counter++;
            }
        }

//        System.out.println(counter); // Check if counter is working
        if (counter == size()) return true;
        else return false;
    }

    /**
     * Static Method:
     * This method is for calculating the number of elements in the multidimensional array.
     * There is no predefined method for returning the number of elements in a multidimensional array.
     * Instead of looping through the array, this method uses recursion to find the number of elements.
     * This takes an Object type parameter which will make it so any class type can be inserted.
     * This is because the Object class is the parent of all classes.
     * @param object
     * @return
     */
    private static int calculateSize(Object object) {
        if (!object.getClass().isArray()) {
            return 1;
        }

        int size = 0;
        for (int i = 0; i < Array.getLength(object); i++) {
            size += calculateSize(Array.get(object, i));
        }
        return size;
    }

    /**
     * Normal Method:
     * This method returns the number of elements in the board.
     * @return
     */
    public int size() {
        return calculateSize(layout);
    }

    /**
     * Normal Method:
     * This method takes in a row index and then checks if the row in the array has all 'X' values.
     * If so, then it returns true.
     * @param row
     * @return
     */
    private boolean checkXInRow(int row) {
        if (layout[row][0] == 'X' && layout[row][1] == 'X' && layout[row][2] == 'X')
            return true;
        else return false;
    }

    /**
     * Normal Method:
     * This method takes in a column index and then checks if the column in the array has all 'O' values.
     * If so, then it returns true.
     * @param column
     * @return
     */
    private boolean checkXInColumn(int column) {
        if (layout[0][column] == 'X' && layout[1][column] == 'X' && layout[2][column] == 'X')
            return true;
        else return false;
    }

    /**
     * Normal Method:
     * This method checks the board diagonally for 'X' and if it is in all 3 spots, then the method returns true.
     * @return
     */
    private boolean checkXDiagonally() {
        if (layout[0][0] == 'X' && layout[1][1] == 'X' && layout[2][2] == 'X')
            return true;
        else if (layout[0][2] == 'X' && layout[1][1] == 'X' && layout[2][0] == 'X')
            return true;
        else return false;
    }

    /**
     * Normal Method:
     * This method combines all the checks into one full check.
     * If there are 3 'X' in the right spots, then it will return true.
     * @return
     */
    public boolean checkX() {
        for (int i = 0; i < layout.length; i++) {
            if (checkXInRow(i)) return true;
            else if (checkXInColumn(i)) return true;
        }

        if (checkXDiagonally()) return true;

        return false;
    }

    /**
     * Normal Method:
     * This method takes in a row index and then checks if the row in the array has all 'O' values.
     * If so, then it returns true.
     * @param row
     * @return
     */
    private boolean checkOInRow(int row) {
        if (layout[row][0] == 'O' && layout[row][1] == 'O' && layout[row][2] == 'O')
            return true;
        else return false;
    }

    /**
     * Normal Method:
     * This method takes in a column index and then checks if the column in the array has all 'O' values.
     * If so, then it returns true.
     * @param column
     * @return
     */
    private boolean checkOInColumn(int column) {
        if (layout[0][column] == 'O' && layout[1][column] == 'O' && layout[2][column] == 'O')
            return true;
        else return false;
    }

    /**
     * Normal Method:
     * This method checks the board diagonally for 'O' and if it is in all 3 spots, then the method returns true.
     * @return
     */
    private boolean checkODiagonally() {
        if (layout[0][0] == 'O' && layout[1][1] == 'O' && layout[2][2] == 'O')
            return true;
        else if (layout[0][2] == 'O' && layout[1][1] == 'O' && layout[2][0] == 'O')
            return true;
        else return false;
    }

    /**
     * Normal Method:
     * This method combines all the checks into one full check.
     * If there are 3 'O' in the right spots, then it will return true.
     * @return
     */
    public boolean checkO() {
        for (int i = 0; i < layout.length; i++) {
            if (checkOInRow(i)) return true;
            else if (checkOInColumn(i)) return true;
        }

        if (checkODiagonally()) return true;

        return false;
    }

}
