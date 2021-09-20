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

    // O(M * N) time | O(N * N) space
    public String tictactoe(int[][] moves) {
        char[][] board = new char[N][N];
        int player = 0;

        for (int[] move : moves) {
            int row = move[0];
            int col = move[1];

            char mark = (char)('A' + player);
            board[row][col] = mark;

            if (checkRow(board, row, mark)
                    || checkCol(board, col, mark)
                    || (row == col && checkDiagonal(board, mark, true))
                    || (row + col == N - 1 && checkDiagonal(board, mark, false))) {
                return String.valueOf(mark);
            }
            player = (player + 1) % 2;
        }
        return (moves.length == N * N) ? "Draw" : "Pending";
    }

    private boolean checkRow(char[][] board, int row, char mark) {
        for (int col = 0; col < N; col++) {
            if (board[row][col] != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col, char mark) {
        for (int row = 0; row < N; row++) {
            if (board[row][col] != mark) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(char[][] board, char mark, boolean main) {
        int col = main ? 0 : N - 1;
        int dy = main ? 1 : -1;
        for (int row = 0; row < N; row++) {
            if (board[row][col] != mark) {
                return false;
            }
            col += dy;
        }
        return true;
    }
}
