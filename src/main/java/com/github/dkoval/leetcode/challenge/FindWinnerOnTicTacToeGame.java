package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3981/">Find Winner on a Tic Tac Toe Game</a>
 * <p>
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <ul>
 *  <li>Players take turns placing characters into empty squares (" ").</li>
 *  <li>The first player A always places "X" characters, while the second player B always places "O" characters.</li>
 *  <li>"X" and "O" characters are always placed into empty squares, never on filled ones.</li>
 *  <li>The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.</li>
 *  <li>The game also ends if all squares are non-empty.</li>
 *  <li>No more moves can be played if the game is over.</li>
 * </ul>
 * Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid
 * where they mark their respective character in the order in which A and B play.
 * <p>
 * Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw",
 * if there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 */
public class FindWinnerOnTicTacToeGame {

    private static final int N = 3;

    private static class XsAnd0s {
        int numXs = 0;
        int num0s = 0;
    }

    private enum Winner {
        PLAYER_A("A"),
        PLAYER_B("B");

        static Winner of(XsAnd0s counts) {
            return (counts.numXs == N)
                    ? Winner.PLAYER_A
                    : ((counts.num0s == N) ? Winner.PLAYER_B : null);
        }

        final String text;

        Winner(String text) {
            this.text = text;
        }
    }

    public String tictactoe(int[][] moves) {
        char[][] board = new char[N][N];
        int i = 0;
        for (int[] move : moves) {
            char c = (i++ % 2 == 0) ? 'X' : '0';
            board[move[0]][move[1]] = c;
        }
        return checkBoard(board, moves.length);
    }

    private String checkBoard(char[][] board, int numMoves) {
        Winner winner;

        // check rows
        for (int row = 0; row < N; row++) {
            winner = checkRow(board, row);
            if (winner != null) {
                return winner.text;
            }
        }

        // check columns
        for (int col = 0; col < N; col++) {
            winner = checkCol(board, col);
            if (winner != null) {
                return winner.text;
            }
        }

        // check main diagonal
        winner = checkDiagonal(board, true);
        if (winner != null) {
            return winner.text;
        }

        // check anti-diagonal
        winner = checkDiagonal(board, false);
        if (winner != null) {
            return winner.text;
        }

        return (numMoves == N * N) ? "Draw" : "Pending";
    }

    private Winner checkRow(char[][] board, int row) {
        XsAnd0s counts = new XsAnd0s();
        for (int col = 0; col < N; col++) {
            if (board[row][col] == 'X') {
                counts.numXs++;
            } else if (board[row][col] == '0') {
                counts.num0s++;
            }
        }
        return Winner.of(counts);
    }

    private Winner checkCol(char[][] board, int col) {
        XsAnd0s counts = new XsAnd0s();
        for (int row = 0; row < N; row++) {
            if (board[row][col] == 'X') {
                counts.numXs++;
            } else if (board[row][col] == '0') {
                counts.num0s++;
            }
        }
        return Winner.of(counts);
    }

    private Winner checkDiagonal(char[][] board, boolean main) {
        XsAnd0s counts = new XsAnd0s();
        int col = main ? 0 : N - 1;
        int deltaCol = main ? 1 : -1;
        for (int row = 0; row < N; row++) {
            if (board[row][col] == 'X') {
                counts.numXs++;
            } else if (board[row][col] == '0') {
                counts.num0s++;
            }
            col += deltaCol;
        }
        return Winner.of(counts);
    }
}
