package com.game;

import com.layout.*;

public class TicTacToe {
    public static void startGame() {
        // Create a board
        Board board = new Board();

        System.out.println("Tic-Tac-Toe");

        board.displayBoard();

        System.out.println(board.isFull());

        // Testing if isFull() works properly
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                board.setX(i, j);
//            }
//        }
//        board.displayBoard();
//        System.out.println(board.isFull());


    }
}
