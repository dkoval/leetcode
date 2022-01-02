package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3559/">Pairs of Songs With Total Durations Divisible by 60</a>
 * <p>
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 * <p>
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= time.length <= 6 * 10^4</li>
 * <li>1 <= time[i] <= 500</li>
 * </ul>
 */
public interface PairsOfSongsWithTotalDurationsDivisibleBy60 {

    int numPairsDivisibleBy60(int[] time);

    // Brute force: O(N^2) time | O(1) space
    // Results in TLE
    class PairsOfSongsWithTotalDurationsDivisibleBy60BruteForce implements PairsOfSongsWithTotalDurationsDivisibleBy60 {

        @Override
        public int numPairsDivisibleBy60(int[] time) {
            int numPairs = 0;
            for (int i = 0; i < time.length; i++) {
                for (int j = i + 1; j < time.length; j++) {
                    if ((time[i] + time[j]) % 60 == 0) {
                        numPairs++;
                    }
                }
            }
            return numPairs;
        }
    }

    // O(N) time | O(60) = O(1) space
    class PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemainders implements PairsOfSongsWithTotalDurationsDivisibleBy60 {

        @Override
        public int numPairsDivisibleBy60(int[] time) {
            // Theory:
            // (time[i] + time[j]) % 60 = 0
            // (time[i] % 60 + time[j] % 60) % 60 = 0

            // Reduce times into their congruence classes of mod 60.
            // remainders[i] is the number of remainders equal to i
            int[] remainders = new int[60];
            for (int t : time) {
                remainders[t % 60]++;
            }

            // Corner cases: handle 0 and 30 remainders separately.
            // The umber of pairs that can be formed out of n elements is
            // C(n, 2) = n * (n - 1) / 2
            int count = numPairs(remainders[0]) + numPairs(remainders[30]);
            for (int i = 1; i <= 29; i++) {
                count += remainders[i] * remainders[60 - i];
            }
            return count;
        }

        private int numPairs(int n) {
            // C(n, 2) = n * (n - 1) / 2
            return n * (n - 1) / 2;
        }
    }

    // O(N) time | O(60) = O(1) space
    class PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemaindersRefactored implements PairsOfSongsWithTotalDurationsDivisibleBy60 {

        @Override
        public int numPairsDivisibleBy60(int[] time) {
            // remainders[i] is the number of remainders equal to i
            int[] remainders = new int[60];

            // (prev + curr) % 60 = 0
            // (prev % 60 + curr % 60) = 0
            // prev % 60 = -curr % 60 = (60 - curr % 60) % 60
            int count = 0;
            for (int t : time) {
                int prev = (60 - t % 60) % 60;
                // can form remainders[prev] number of pairs with time t
                count += remainders[prev];
                remainders[t % 60]++;
            }
            return count;

        }
    }
}
