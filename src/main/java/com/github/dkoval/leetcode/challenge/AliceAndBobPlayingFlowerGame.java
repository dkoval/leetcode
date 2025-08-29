package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/alice-and-bob-playing-flower-game/">Alice and Bob Playing Flower Game</a>
 * <p>
 * Alice and Bob are playing a turn-based game on a field, with two lanes of flowers between them.
 * There are x flowers in the first lane between Alice and Bob, and y flowers in the second lane between them.
 * <p>
 * The game proceeds as follows:
 * <ul>
 *  <li>Alice takes the first turn.</li>
 *  <li>In each turn, a player must choose either one of the lane and pick one flower from that side.</li>
 *  <li>At the end of the turn, if there are no flowers left at all, the current player captures their opponent and wins the game.</li>
 * </ul>
 * Given two integers, n and m, the task is to compute the number of possible pairs (x, y) that satisfy the conditions:
 * <ul>
 *  <li>Alice must win the game according to the described rules.</li>
 *  <li>The number of flowers x in the first lane must be in the range [1,n].</li>
 *  <li>The number of flowers y in the second lane must be in the range [1,m].</li>
 * </ul>
 * Return the number of possible pairs (x, y) that satisfy the conditions mentioned in the statement.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n, m <= 10^5
 */
public interface AliceAndBobPlayingFlowerGame {

    long flowerGame(int n, int m);

    class AliceAndBobPlayingFlowerGameRev1 implements AliceAndBobPlayingFlowerGame {

        @Override
        public long flowerGame(int n, int m) {
            // Alice wins only IFF the total number of flowers in odd <=> (x, y) have different parities
            final var nEvens = n / 2;
            final var nOdds = n - nEvens;

            final var mEvens = m / 2;
            final var mOdds = m - mEvens;

            // the total number of (x, y) pairs
            return (long) nEvens * mOdds + (long) nOdds * mEvens;
        }
    }
}
