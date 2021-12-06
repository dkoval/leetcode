package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/">Minimum Cost to Move Chips to The Same Position</a>
 * <p>
 * We have n chips, where the position of the ith chip is position[i].
 * <p>
 * We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
 * <ul>
 *  <li>position[i] + 2 or position[i] - 2 with cost = 0.</li>
 *  <li>position[i] + 1 or position[i] - 1 with cost = 1.</li>
 * </ul>
 * Return the minimum cost needed to move all the chips to the same position.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= position.length <= 100</li>
 *  <li>1 <= position[i] <= 10^9</li>
 * </ul>
 */
public class MinimumCostToMoveChipsToTheSamePosition {

    // O(N) time | O(1) space
    public int minCostToMoveChips(int[] positions) {
        int numChipsAtEvenPositions = 0;
        int numChipsAtOddPositions = 0;
        for (int position : positions) {
            if (position % 2 == 0) {
                numChipsAtEvenPositions++;
            } else {
                numChipsAtOddPositions++;
            }
        }
        return Math.min(numChipsAtEvenPositions, numChipsAtOddPositions);
    }
}
