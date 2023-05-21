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


        while (!board.isFull()) {

            boolean check = true;

            if (counter % 2 == 0) {

                // Will loop until Player 1 input is correct
                while (check) {
                    // Scanner has to be inside loop otherwise it'll keep the same values and loop infinitely
                    Scanner scan = new Scanner(System.in);

                    System.out.print("Ready Player 1? Enter row and column index: ");

                    // Check if input is a number
                    try {
                        int row = scan.nextInt();
                        int column = scan.nextInt();

                        // Check if input falls within bounds of board
                        if ((row >= 0 && row < board.getRowSize()) && (column >= 0 && column < board.getRowSize())) {
                            // Check if input falls into an open spot
                            if (!board.isOccupied(row, column)) {
                                board.setX(row, column);
                                break;
                            } else System.out.println("Spot has been taken. Try again.");
                        } else
                            System.out.println("Try again Player 1. Make sure row and column fall within the board.");
                    } catch (Exception e) {
                        System.out.println("Enter two numbers that are between 0 and 2 inclusive");
                    }

                    scan.close();
                }

                // Check after correct input if player has won
                if (board.checkX()) {
                    System.out.println("Congrats Player 1! You win!");
                    board.displayBoard();
                    break;
                }

                board.displayBoard();

            } else {

                // Will loop until Player 2 input is correct
                while (check) {
                    // Scanner has to be inside loop otherwise it'll keep the same values and loop infinitely
                    Scanner scan = new Scanner(System.in);

                    System.out.print("Ready Player 2? Enter row and column index: ");

                    // Check for input that isn't a number
                    try {
                        int row = scan.nextInt();
                        int column = scan.nextInt();

                        // Check if input is within bounds of board
                        if ((row >= 0 && row < board.getRowSize()) && (column >= 0 && column < board.getRowSize())) {
                            // Check if spot is taken
                            if (!board.isOccupied(row, column)) {
                                board.setO(row, column);
                                break;
                            } else System.out.println("Spot has been taken. Try again.");
                        } else
                            System.out.println("Try again Player 2. Make sure row and column fall within the board.");
                    } catch (Exception e) {
                        System.out.println("Enter two numbers that are between 0 and 2 inclusive");
                    }

                    scan.close();
                }

                // Check after correct input if player has won
                if (board.checkO()) {
                    System.out.println("Congrats Player 2! You win!");
                    board.displayBoard();
                    break;
                }

                board.displayBoard();

            }

            counter++;

        }

        if (board.isFull()) System.out.println("No winner. Board is full");

    }
}
