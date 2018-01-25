package com.implementation.algorithms.dynamic_programming;

public class MinimumCostPath {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1,2,3,4},
                {8,7,6,5},
                {4,3,2,1},
                {1,7,2,9}
        };

        MinimumCostPath minimumCostPath = new MinimumCostPath();
        System.out.println("Now, printing the actual matrix");
        minimumCostPath.printMatrix(matrix, 4, 4);

        int[][] minimumPathMatrix = minimumCostPath.getMinimumCostMatrix(matrix, 4, 4);
        System.out.println("Now, printing the minimum path matrix");
        minimumCostPath.printMatrix(minimumPathMatrix, 4, 4);
        System.out.println("Minimum cost for reaching the last node is: " + minimumPathMatrix[3][3]);

        int[][] numWaysMatrix = minimumCostPath.numWays(matrix, 4, 4);
        System.out.println("Now, printing the number of ways to the node matrix");
        minimumCostPath.printMatrix(numWaysMatrix, 4, 4);
        System.out.println("No ways for reaching the last node is: " + numWaysMatrix[3][3]);

        int[][] mazeMatrix = new int[][] {
                {0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}
        };
        mazeMatrix = minimumCostPath.mazeNumWays(mazeMatrix, 4, 4);
        System.out.println("Now, printing the number of ways to the maze matrix");
        minimumCostPath.printMatrix(mazeMatrix, 4, 4);
        System.out.println("No ways for reaching the last node of a maze matrix is: " + mazeMatrix[3][3]);

    }

    /*
    Finding the number of ways to reach a particular position in a grid from a starting position (given some cells which are blocked)
    */
    public int[][] mazeNumWays(int[][] maze, int rowLength, int colLength) {
        if( maze[0][0] == -1 ) {
            return maze;
        }

        for (int i = 1; i < rowLength; i++) {
            if ( maze[0][i] == -1 ) {
                break;
            } else if(maze[0][i] == 0){
                maze[0][i] = 1;
            }
        }

        // initiating all first column values
        for (int i = 1; i < colLength; i++) {
            if ( maze[i][0] == -1 ) {
                break;
            } else if(maze[i][0] == 0){
                maze[i][0] = 1;
            }
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if(maze[i][j] == -1) {
                    continue;
                }

                if (maze[i][j-1] > 0) {
                    maze[i][j] = maze[i][j-1] + maze[i][j];
                }

                if (maze[i-1][j] > 0) {
                    maze[i][j] = maze[i-1][j] + maze[i][j];
                }
            }
        }

        return  maze;
    }

    /*
    Finding the number of ways to reach from a starting position to an ending position travelling in specified directions only.
    */
    public int[][] numWays(int[][] matrix, int rowLength, int colLength) {
        int[][] numWays = new int[rowLength][colLength];

        numWays[0][0] = 1;

        // initiating all first rows values
        for (int i = 1; i < rowLength; i++) {
            numWays[0][i] = 1;
        }

        // initiating all first column values
        for (int i = 1; i < colLength; i++) {
            numWays[i][0] = 1;
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                numWays[i][j] = numWays[i-1][j] + numWays[i][j-1];
            }
        }

        return  numWays;
    }

    /*
    Finding Minimum-Cost Path in a 2-D Matrix:
    Given a cost matrix Cost[][] where Cost[i][j] denotes the Cost of visiting cell with coordinates (i,j),
    find a min-cost path to reach a cell (x,y) from cell (0,0)
    under the condition that you can only travel one step right or one step down.
    (We assume that all costs are positive integers)
    */

    public int[][] getMinimumCostMatrix(int[][] matrix, int rowLength, int colLength) {
        int[][] minPathMatrix = new int[rowLength][colLength];

        minPathMatrix[0][0] = matrix[0][0];

        // initiating all first rows values
        for (int i = 1; i < rowLength; i++) {
            minPathMatrix[0][i] = minPathMatrix[0][i-1] + matrix[0][i];
        }

        // initiating all first column values
        for (int i = 1; i < colLength; i++) {
            minPathMatrix[i][0] = minPathMatrix[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                minPathMatrix[i][j] = Math.min( minPathMatrix[i][j-1], minPathMatrix[i-1][j] ) + matrix[i][j];
            }
        }

        return minPathMatrix;
    }

    // simple method to print a 2D matrix

    public void printMatrix(int[][] matrix, int rowLength, int colLength) {

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("  ");
            }
            System.out.println("");
        }

    }

}
