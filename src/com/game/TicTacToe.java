package com.game;

import com.layout.*;

public class TicTacToe {
    public static void startGame() {
        // Create a board
        Board board = new Board();

        System.out.println("Tic-Tac-Toe");

        for(int i = 0; i < board.getRowSize(); i++) {
            System.out.print("|");
            for(int j = 0; j < board.getRowSize(); j++) {
                System.out.print(" " + board.getValue(i, j) + " |");
            }
            System.out.println();
        }
    }
}
