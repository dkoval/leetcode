package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

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
            final var n = board.length;

            // BFS
            final var start = Square.fromLabel(1, n);

            final var q = new ArrayDeque<Square>();
            final var visited = new boolean[n][n];
            q.offer(start);
            visited[start.row][start.col] = true;

            var moves = 0;
            while (!q.isEmpty()) {
                // process all squares at the current level
                var size = q.size();
                while (size-- > 0) {
                    final var curr = q.poll();
                    // choose a next destination square with a label in the range [curr + 1, min(curr + 6, n^2)]
                    for (var x = curr.x + 1; x <= Math.min(curr.x + 6, n * n); x++) {
                        // If next has a snake or ladder, you must move to the destination of that snake or ladder.
                        // Otherwise, you move to next.
                        var next = Square.fromLabel(x, n);
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

        record Square(int row, int col, int x) {

            // convert label x to (row, col) coordinates on the board
            static Square fromLabel(int x, int n) {
                final var r = (x - 1) / n;
                final var c = (x - 1) % n;
                final var row = n - 1 - r;
                final var col = (r % 2 == 0) ? c : n - 1 - c;
                return new Square(row, col, x);
            }
        }
    }
}
