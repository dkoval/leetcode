package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/snakes-and-ladders/">Snakes and Ladders</a>
 * <p>
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n^2 in a <a href="https://en.wikipedia.org/wiki/Boustrophedon">Boustrophedon style</a>
 * starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
 * <p>
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 * <p>
 * Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
 * This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
 * If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
 * The game ends when you reach the square n2.
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c].
 * Squares 1 and n2 do not have a snake or ladder.
 * <p>
 * Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder,
 * you do not follow the subsequent snake or ladder.
 * <p>
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
 * You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
 * Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == board.length == board[i].length</li>
 *  <li>2 <= n <= 20</li>
 *  <li>grid[i][j] is either -1 or in the range [1, n2].</li>
 *  <li>The squares labeled 1 and n2 do not have any ladders or snakes.</li>
 * </ul>
 */
public interface SnakesAndLadders {

    int snakesAndLadders(int[][] board);

    class SnakesAndLaddersRev1 implements SnakesAndLadders {

        @Override
        public int snakesAndLadders(int[][] board) {
            int n = board.length;

            // BFS to find the shortest path from source = 1 to target = n^2
            Queue<Square> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];

            int moves = 0;
            Square start = Square.fromLabel(1, n);
            q.offer(start);
            visited[start.row][start.col] = true;
            while (!q.isEmpty()) {
                // process all squares at the current level
                int size = q.size();
                while (size-- > 0) {
                    Square curr = q.poll();
                    // choose a next destination square with a label in the range [curr + 1, min(curr + 6, n^2)]
                    for (int x = curr.x + 1; x <= Math.min(curr.x + 6, n * n); x++) {
                        // convert label to (row, col) coordinates on the board
                        Square next = Square.fromLabel(x, n);

                        // If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
                        if (board[next.row][next.col] != -1) {
                            next = Square.fromLabel(board[next.row][next.col], n);
                        }

                        if (next.x == n * n) {
                            return moves + 1;
                        }

                        if (!visited[next.row][next.col]) {
                            q.offer(next);
                            visited[next.row][next.col] = true;
                        }
                    }
                }
                moves++;
            }
            return -1;
        }

        private static class Square {
            final int row;
            final int col;
            final int x;

            Square(int row, int col, int x) {
                this.row = row;
                this.col = col;
                this.x = x;
            }

            static Square fromLabel(int x, int n) {
                int d = (x - 1) / n;
                int r = (x - 1) % n;
                int row = n - 1 - d;
                int col = (d % 2 == 0) ? r : n - 1 - r;
                return new Square(row, col, x);
            }
        }
    }
}
