package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3775/">Stone Game VII</a>
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost
 * stone from the row and receive points equal to the sum of the remaining stones' values in the row.
 * The winner is the one with the higher score when there are no stones left to remove.
 * <p>
 * Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's
 * difference. Alice's goal is to maximize the difference in the score.
 * <p>
 * Given an array of integers stones where stones[i] represents the value of the ith stone from the left,
 * return the difference in Alice and Bob's score if they both play optimally.
 */
public interface StoneGame7 {

    int stoneGameVII(int[] stones);

    class StoneGame7TopDownWithMemoization implements StoneGame7 {

        @Override
        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            return play(prefixSum(stones), 0, n - 1, new Integer[n][n]);
        }

        private int play(int[] prefixSum, int left, int right, Integer[][] memo) {
            if (left == right) {
                return 0;
            }

            if (memo[left][right] != null) {
                return memo[left][right];
            }

            // 1st player takes the left stone, then the 2nd player plays his turn
            int leftDiff = score(prefixSum, left + 1, right) - play(prefixSum, left + 1, right, memo);

            // 1st player takes the right stone, then the 2nd player plays his turn
            int rightDiff = score(prefixSum, left, right - 1) - play(prefixSum, left, right - 1, memo);

            // Take the best of 2 diffs
            int maxDiff = Math.max(leftDiff, rightDiff);
            memo[left][right] = maxDiff;
            return maxDiff;
        }

        private int[] prefixSum(int[] stones) {
            int[] result = new int[stones.length];
            result[0] = stones[0];
            for (int i = 1; i < stones.length; i++) {
                result[i] = result[i - 1] + stones[i];
            }
            return result;
        }

        private int score(int[] prefixSum, int left, int right) {
            return prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0);
        }
    }
}
