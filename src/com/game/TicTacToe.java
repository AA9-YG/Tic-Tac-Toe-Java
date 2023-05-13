package com.game;

import com.layout.*;

import java.util.Scanner;

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

        int counter = 0;
        Scanner scan = new Scanner(System.in);

        while (!board.isFull()) {
            if (counter % 2 == 0) {
                System.out.print("Ready Player 1? Enter row and column index: ");
                int row = scan.nextInt();
                int column = scan.nextInt();
                board.setX(row, column);

                board.displayBoard();

            } else {
                System.out.print("Ready Player 2? Enter row and column index: ");
                int row = scan.nextInt();
                int column = scan.nextInt();
                board.setO(row, column);

                board.displayBoard();

            }

            counter++;

        }

    }
}
