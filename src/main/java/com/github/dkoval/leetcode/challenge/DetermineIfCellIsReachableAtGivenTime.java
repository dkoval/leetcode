package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/">Determine if a Cell Is Reachable at a Given Time</a>
 * <p>
 * You are given four integers sx, sy, fx, fy, and a non-negative integer t.
 * <p>
 * In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.
 * <p>
 * Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.
 * <p>
 * A cell's adjacent cells are the 8 cells around it that share at least one corner with it. You can visit the same cell several times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= sx, sy, fx, fy <= 10^9</li>
 *  <li>0 <= t <= 10^9</li>
 * </ul>
 */
public interface DetermineIfCellIsReachableAtGivenTime {

    boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t);

    // O(1) time | O(1) space
    class DetermineIfCellIsReachableAtGivenTimeRev1 implements DetermineIfCellIsReachableAtGivenTime {

        @Override
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
            // Observation: going diagonally is always optimal.
            // optimal time = # steps going diagonally + # steps going horizontally (or vertically).
            //
            // Example 1:
            // S
            //  \
            //   \
            //    \
            //     ------ F
            //
            // Example 2:
            // S
            //  \
            //   \
            //    \
            //     |
            //     |
            //     F
            //
            // optimal time = min(dx, dy) + (max(dx, dy) - min(dx, dy)) = max(dx, dy)
            // Can reach "Finish" if optimal time <= t.
            // Corner case: can't make it if "Start" = "Finish" and t = 1.
            if (sx == fx && sy == fy && t == 1) {
                return false;
            }

            int dx = Math.abs(fx - sx);
            int dy = Math.abs(fy - sy);
            return Math.max(dx, dy) <= t;
        }
    }
}
