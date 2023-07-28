package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/predict-the-winner/">Predict the Winner</a>
 * <p>
 * You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
 * <p>
 * Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0.
 * At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1])
 * which reduces the size of the array by 1. The player adds the chosen number to their score.
 * The game ends when there are no more elements in the array.
 * <p>
 * Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner,
 * and you should also return true. You may assume that both players are playing optimally.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 20</li>
 *  <li>0 <= nums[i] <= 10^7</li>
 * </ul>
 */
public interface PredictWinner {

    boolean predictTheWinner(int[] nums);

    class PredictWinnerBruteForce implements PredictWinner {

        @Override
        public boolean predictTheWinner(int[] nums) {
            int n = nums.length;
            int[] scores = calculate(nums, 0, 0, n - 1);
            return scores[0] >= scores[1];
        }

        private int[] calculate(int[] nums, int player, int left, int right) {
            if (left > right) {
                return new int[]{0, 0};
            }

            // option #1: player X chooses nums[left]
            int[] scores1 = calculate(nums, (player + 1) % 2, left + 1, right);
            scores1[player] += nums[left];

            // option #2: player X chooses nums[right]
            int[] scores2 = calculate(nums, (player + 1) % 2, left, right - 1);
            scores2[player] += nums[right];

            return (scores1[player] >= scores2[player]) ? scores1 : scores2;
        }
    }
}
