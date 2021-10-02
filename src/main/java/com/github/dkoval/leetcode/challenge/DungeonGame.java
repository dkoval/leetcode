package com.github.dkoval.leetcode.challenge;

public interface DungeonGame {

    int calculateMinimumHP(int[][] dungeon);

    // O(M * N) time | O(M * N) space
    class DungeonGameRecursiveWithMemoization implements DungeonGame {

        @Override
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            Integer[][] memo = new Integer[m][n];
            return calculateMinimumHP(dungeon, 0, 0, memo);
        }

        private int calculateMinimumHP(int[][] dungeon, int row, int col, Integer[][] memo) {
            // idea is to solve the problem in reverse
            int m = dungeon.length;
            int n = dungeon[0].length;

            // base case: min health points needed in the bottom-right corner for the knight to survive
            if (row == m - 1 && col == n - 1) {
                return (dungeon[row][col] > 0) ? 1 : 1 - dungeon[row][col];
            }

            if (memo[row][col] != null) {
                return memo[row][col];
            }

            int answer = Integer.MAX_VALUE;

            // go right
            if (col + 1 < n) {
                int minRight = calculateMinimumHP(dungeon, row, col + 1, memo);
                answer = Math.min(answer, ensureAlive(minRight - dungeon[row][col]));
            }

            // go down
            if (row + 1 < m) {
                int minDown = calculateMinimumHP(dungeon, row + 1, col, memo);
                answer = Math.min(answer, ensureAlive(minDown - dungeon[row][col]));
            }

            memo[row][col] = answer;
            return answer;
        }

        private int ensureAlive(int healthPoints) {
            return Math.max(healthPoints, 1);
        }
    }

    // O(M * N) time | O(M * N) space
    class DungeonGameDPJava implements DungeonGame {

        @Override
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;

            // hp[i][j] - min health points needed in the bottom-right for the knight to stay alive
            int[][] hp = new int[m][n];

            // base case
            hp[m - 1][n - 1] = (dungeon[m - 1][n - 1] > 0) ? 1 : 1 - dungeon[m - 1][n - 1];

            // solve for the remaining cells going bottom-up and right-to-left
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        continue;
                    }

                    int best = Integer.MAX_VALUE;
                    // go right
                    if (j + 1 < n) {
                        best = Math.min(best, ensureAlive(hp[i][j + 1] - dungeon[i][j]));
                    }
                    // go down
                    if (i + 1 < m) {
                        best = Math.min(best, ensureAlive(hp[i + 1][j] - dungeon[i][j]));
                    }
                    hp[i][j] = best;
                }
            }
            return hp[0][0];
        }

        private int ensureAlive(int healthPoints) {
            return Math.max(healthPoints, 1);
        }
    }
}
