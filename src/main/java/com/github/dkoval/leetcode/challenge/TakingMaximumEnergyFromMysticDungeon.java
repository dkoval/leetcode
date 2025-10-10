package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/">Taking Maximum Energy From the Mystic Dungeon</a>
 * <p>
 * In a mystic dungeon, n magicians are standing in a line. Each magician has an attribute that gives you energy.
 * Some magicians can give you negative energy, which means taking energy from you.
 * <p>
 * You have been cursed in such a way that after absorbing energy from magician i, you will be instantly transported to magician (i + k).
 * This process will be repeated until you reach the magician where (i + k) does not exist.
 * <p>
 * In other words, you will choose a starting point and then teleport with k jumps until you reach the end of the magicians' sequence,
 * absorbing all the energy during the journey.
 * <p>
 * You are given an array energy and an integer k. Return the maximum possible energy you can gain.
 * <p>
 * Note that when you are reach a magician, you must take energy from them, whether it is negative or positive energy.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= energy.length <= 10^5</li>
 *  <li>-1000 <= energy[i] <= 1000</li>
 *  <li>1 <= k <= energy.length - 1</li>
 * </ul>
 */
public interface TakingMaximumEnergyFromMysticDungeon {

    int maximumEnergy(int[] energy, int k);

    class TakingMaximumEnergyFromMysticDungeonRev1 implements TakingMaximumEnergyFromMysticDungeon {

        @Override
        public int maximumEnergy(int[] energy, int k) {
            final var n = energy.length;

            // dp[i] - the total energy gained when starting from index i
            final var dp = new Integer[n];
            var best = Integer.MIN_VALUE;
            for (var i = 0; i < n; i++) {
                best = Math.max(best, calc(energy, k, i, dp));
            }
            return best;
        }

        private int calc(int[] energy, int k, int index, Integer[] dp) {
            // base case
            if (index >= energy.length) {
                return 0;
            }

            // already solved?
            if (dp[index] != null) {
                return dp[index];
            }


            var ans = energy[index] + calc(energy, k, index + k, dp);
            return dp[index] = ans;
        }
    }

    class TakingMaximumEnergyFromMysticDungeonRev2 implements TakingMaximumEnergyFromMysticDungeon {

        @Override
        public int maximumEnergy(int[] energy, int k) {
            final var n = energy.length;

            // dp[i] = maximum energy that can be obtained starting from magician i
            final var dp = new int[n];
            // base case
            dp[n - 1] = energy[n - 1];
            // bottom-up DP
            for (var i = n - 2; i >= 0; i--) {
                if (i + k < n) {
                    dp[i] = energy[i] + dp[i + k];
                } else {
                    dp[i] = energy[i];
                }
            }

            // find the maximum energy that can be obtained starting from any magician
            var best = Integer.MIN_VALUE;
            for (var i = 0; i < n; i++) {
                best = Math.max(best, dp[i]);
            }
            return best;
        }
    }
}
