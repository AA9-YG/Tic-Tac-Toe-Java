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

        System.out.println(counter);
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
}
