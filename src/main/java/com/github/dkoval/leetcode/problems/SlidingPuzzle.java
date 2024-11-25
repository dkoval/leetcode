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

    private static int traverse(int[][] board, Cell zero) {
        Board source = new Board(board, zero);
        if (source.isTarget()) {
            return 0;
        }

        // BFS
        Queue<Board> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.offer(source);
        visited.add(source.dump());

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // process the current layer
            while (size-- > 0) {
                Board curr = q.poll();
                for (Direction d : Direction.values()) {
                    boolean found = curr.moveZero(d)
                            .map(next -> {
                                boolean isTarget = next.isTarget();
                                if (!isTarget) {
                                    String key = next.dump();
                                    if (!visited.contains(key)) {
                                        q.offer(next);
                                        visited.add(key);
                                    }
                                }
                                return isTarget;
                            })
                            .orElse(false);

                    if (found) {
                        return count + 1;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 0) {
                    return traverse(board, new Cell(row, col));
                }
            }
        }
        return -1;
    }

    private enum Direction {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

        final int drow;
        final int dcol;

        Direction(int drow, int dcol) {
            this.drow = drow;
            this.dcol = dcol;
        }
    }

    private record Cell(int row, int col) {
    }

    /**
     * @param board actual state of the board
     * @param zero  (row, col) coordinates of 0 cell on the board
     */
    private record Board(int[][] board, Cell zero) {

        boolean isTarget() {
            for (int i = 0; i < board.length; i++) {
                if (!Arrays.equals(board[i], TARGET[i])) {
                    return false;
                }
            }
            return true;
        }

        Optional<Board> moveZero(Direction d) {
            int m = board.length;
            int n = board[0].length;

            int nextRow = zero.row + d.drow;
            int nextCol = zero.col + d.dcol;

            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                return Optional.empty();
            }

            int[][] nextBoard = new int[m][n];
            for (int i = 0; i < m; i++) {
                System.arraycopy(board[i], 0, nextBoard[i], 0, n);
            }

            // swap `zero` with `dest`
            nextBoard[zero.row][zero.col] = board[nextRow][nextCol];
            nextBoard[nextRow][nextCol] = 0;

            return Optional.of(new Board(nextBoard, new Cell(nextRow, nextCol)));
        }

        // Encodes the current state of the board into a String
        String dump() {
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
}
