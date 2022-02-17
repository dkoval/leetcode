package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sliding-puzzle/">Sliding Puzzle (Hard)</a>
 * <p>
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * <p>
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * <p>
 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>board.length == 2</li>
 *  <li>board[i].length == 3</li>
 *  <li>0 <= board[i][j] <= 5</li>
 *  <li>Each value board[i][j] is unique</li>
 * </ul>
 */
public class SlidingPuzzle {

    private static final int[][] TARGET = {
            {1, 2, 3},
            {4, 5, 0}
    };

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static class Cell {
        final int row;
        final int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static class Board {
        // actual state of the board
        final int[][] board;
        // (row, col) coordinates of 0 cell on the board
        final Cell zero;

        Board(int[][] board, Cell zero) {
            this.board = board;
            this.zero = zero;
        }

        boolean isTarget() {
            for (int i = 0; i < board.length; i++) {
                if (!Arrays.equals(board[i], TARGET[i])) {
                    return false;
                }
            }
            return true;
        }

        Board moveZero(Cell dest) {
            int m = board.length;
            int n = board[0].length;

            int[][] nextBoard = new int[m][n];
            for (int i = 0; i < m; i++) {
                System.arraycopy(board[i], 0, nextBoard[i], 0, n);
            }

            // swap `zero` with `dest`
            int tmp = nextBoard[dest.row][dest.col];
            nextBoard[dest.row][dest.col] = 0;
            nextBoard[zero.row][zero.col] = tmp;

            return new Board(nextBoard, dest);
        }

        String encode() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < board.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(Arrays.toString(board[i]));
            }
            sb.append(']');
            return sb.toString();
        }
    }

    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // find 0 cell
        Cell zero = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    zero = new Cell(i, j);
                    break;
                }
            }
        }

        Board source = new Board(board, zero);
        Set<String> seen = new HashSet<>();

        // BFS to find the shortest distance between `source` and `target` states
        Queue<Board> q = new ArrayDeque<>();
        q.offer(source);
        seen.add(source.encode());

        int count = -1;
        while (!q.isEmpty()) {
            boolean done = false;
            int size = q.size();

            // process the current level
            while (size-- > 0) {
                Board curr = q.poll();
                if (curr.isTarget()) {
                    done = true;
                    break;
                }

                for (int[] d : DIRECTIONS) {
                    Cell zeroDest = new Cell(curr.zero.row + d[0], curr.zero.col + d[1]);
                    if (zeroDest.row < 0 || zeroDest.row >= m || zeroDest.col < 0 || zeroDest.col >= n) {
                        continue;
                    }

                    // generate next state of the board by swapping 0 with an adjacent number
                    Board next = curr.moveZero(zeroDest);

                    // add a new state to the next level
                    String enc = next.encode();
                    if (!seen.contains(enc)) {
                        seen.add(enc);
                        q.offer(next);
                    }
                }
            }

            count++;
            if (done) {
                return count;
            }
        }
        return -1;
    }
}
