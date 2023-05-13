package com.game;

import com.layout.*;

import java.util.Scanner;

public class TicTacToe {
    public static void startGame() {
        // Create a board
        Board board = new Board();

        System.out.println("Tic-Tac-Toe");

        board.displayBoard();

//        System.out.println(board.isFull()); // Checking output for isFull()

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

            boolean check = true;

            if (counter % 2 == 0) {

                while(check) {
                    System.out.print("Ready Player 1? Enter row and column index: ");
                    int row = scan.nextInt();
                    int column = scan.nextInt();

                    if ((row >= 0 && row < board.getRowSize()) && (column >= 0 && column < board.getRowSize())) {
                        board.setX(row, column);
                        break;
                    }

                    System.out.println("Try again Player 1. Make sure row and column fall within the board.");
                }

                if (board.checkX()) {
                    System.out.println("Congrats Player 1! You win!");
                    board.displayBoard();
                    break;
                }

                board.displayBoard();

            } else {

                while (check) {
                    System.out.print("Ready Player 2? Enter row and column index: ");
                    int row = scan.nextInt();
                    int column = scan.nextInt();

                    if ((row >= 0 && row < board.getRowSize()) && (column >= 0 && column < board.getRowSize())) {
                        board.setO(row, column);
                        break;
                    }

                    System.out.println("Try again Player 2. Make sure row and column fall within the board.");
                }

                if (board.checkO()) {
                    System.out.println("Congrats Player 2! You win!");
                    board.displayBoard();
                    break;
                }

                board.displayBoard();

            }

            counter++;

        }

    }
}
