package com.implementation.algorithms.game.tictactoe;

import java.util.Scanner;

public class Board {

    String player1 = "X";
    String player2 = "O";
    String currentPlayer;
    Cell[][] cells = new Cell[3][3];

    public void initiateBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell("-",i,j);
            }
        }
        currentPlayer = player1;
    }

    public void takeInput() {

        Scanner scanner = new Scanner(System.in);
        boolean inputReceived = false;

        while (!inputReceived) {
            String playerName;
            if( currentPlayer == player1 ) {
                playerName = "Player 1";
            } else {
                playerName = "Player 2";
            }
            System.out.println(playerName +" ,please enter the row value");
            int rowValue = scanner.nextInt();

            System.out.println(playerName +" ,please enter the row value");
            int colValue = scanner.nextInt();

            if ( ( rowValue > 0 && rowValue < 4 ) && (colValue > 0 && colValue < 4 ) ) {
                if (cells[rowValue-1][colValue-1].getCellValue() != "-") {
                    System.out.println("Please choose a non empty cell");
                } else {
                    inputReceived = true;
                    cells[rowValue-1][colValue-1].setCellValue(currentPlayer);
                }
            } else {
                System.out.println("Please enter a valid input for row number and column number");
            }
        }

    }

    public boolean checkWinningCondition() {
    }

    public boolean isBoardFull() {
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else if(currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    public void printBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j].getCellValue());
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Board board = new Board();

        board.initiateBoard();

        boolean endGame = false;

        while (!endGame) {
            board.takeInput();
            board.printBoard();

            if( board.checkWinningCondition() == true ){
                endGame = true;
            } else if( board.isBoardFull() == true ) {
                endGame = true;
            }

            board.changePlayer();
        }
    }

}
