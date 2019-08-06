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
            String playerName = getCurrentPlayerName();
            System.out.println(playerName +" ,please enter the row and column value eg: 1,2");
            String value = scanner.nextLine();

            int rowValue = Integer.parseInt(value.split(",")[0]);
            int colValue = Integer.parseInt(value.split(",")[1]);

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

    public boolean checkWinningConditions() {
        boolean winningCondition = false;

        if( checkRowWinningCondition() || checkColumnWinningCondition() || checkDiagonalWinningCondition() ) {
            winningCondition = true;
        }

        return winningCondition;
    }

    private boolean checkDiagonalWinningCondition() {
        boolean status = false;

        if( ( checkCellValues(cells[0][0], cells[1][1], cells[2][2]) ) || ( checkCellValues(cells[0][2], cells[1][1], cells[2][0]) ) ) {
            status = true;
        }

        return status;
    }

    private boolean checkColumnWinningCondition() {
        boolean status = false;

        for (int i = 0; i < 3; i++) {
            if( checkCellValues(cells[0][i], cells[1][i], cells[2][i]) ) {
                status = true;
                break;
            }
        }

        return status;
    }

    private boolean checkRowWinningCondition() {
        boolean status = false;

        for (int i = 0; i < 3; i++) {
            if( checkCellValues(cells[i][0], cells[i][1], cells[i][2]) ) {
                status = true;
                break;
            }
        }

        return status;
    }

    private boolean checkCellValues(Cell cell, Cell cell1, Cell cell2) {
        boolean status = false;
        if ( (cell.getCellValue() != "-") && ( cell.getCellValue() == cell1.getCellValue() ) && ( cell1.getCellValue() == cell2.getCellValue()) ) {
            status = true;
        }
        return status;
    }

    public boolean isBoardFull() {
        boolean status = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getCellValue() == "-") {
                    status = false;
                    break;
                }
            }
            if (!status) {
                break;
            }
        }

        return status;
    }

    public String getCurrentPlayerName() {
        String playerName;
        if( currentPlayer == player1 ) {
            playerName = "Player one";
        } else {
            playerName = "Player 2";
        }
        return playerName;
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

        board.printBoard();

        while (!endGame) {
            board.takeInput();
            board.printBoard();

            if( board.checkWinningConditions() == true ){
                endGame = true;

                String playerName = board.getCurrentPlayerName();

                System.out.println("Cool, found winner");
                System.out.println(playerName+" is the winner");
            } else if( board.isBoardFull() == true ) {
                endGame = true;
                System.out.println("Draw game please try again");
            }

            board.changePlayer();
        }
    }

}
