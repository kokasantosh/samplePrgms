package com.sample.algo;

import java.util.Arrays;

public class NQueenProblem {

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        NQueenProblem nQueenProblem = new NQueenProblem();
        Position[] positions = nQueenProblem.solveNQueenProblem(4);

        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
    }

    public Position[] solveNQueenProblem(int n) {

        Position[] positions = new Position[n];

        boolean hasSolution = solveNqueenProblemUtil1(n, 0, positions);

        if(hasSolution) { return positions;} else { return new Position[0];}

    }

    private boolean solveNqueenProblemUtil(int n, int row, Position[] positions) {

        if(n == row) { return true; }

        for(int col = 0; col < n; col ++) {
            boolean foundSafe = true;
            for(int queen = 0; queen < row ; queen++) {
                if((positions[queen].col == col) || (positions[queen].row + positions[queen].col == row + col) || (positions[queen].row - positions[queen].col == row - col)) {
                    foundSafe = false;
                    break;
                }
            }
            if(foundSafe) {
                positions[row] = new Position(row, col);
                if(solveNqueenProblemUtil(n, row+1, positions)){return true;}
            }
        }
        return false;
    }


    private boolean solveNqueenProblemUtil1(int n, int row, Position[] positions) {

        if(n == row) {return true;}

        for(int col = 0 ; col < n; col ++) {
            boolean foundSafe = true;

            for(int queen = 0; queen < row; queen++) {
                if(positions[queen].col == col || positions[queen].row + positions[queen].col == row + col || positions[queen].row - positions[queen].col == row - col) {
                    foundSafe = false;
                    break;
                }
            }

            if(foundSafe) {
                positions[row] = new Position(row, col);
                if(solveNqueenProblemUtil1(n, row+1, positions)) return true;
            }
        }
        return false;
    }

}
