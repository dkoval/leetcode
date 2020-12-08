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
public abstract class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public abstract int numPairsDivisibleBy60(int[] time);

    // Brute force: O(N^2) time | O(1) space
    // Results in TLE
    public static class PairsOfSongsWithTotalDurationsDivisibleBy60BruteForce extends PairsOfSongsWithTotalDurationsDivisibleBy60 {

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

    public static class PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemainders extends PairsOfSongsWithTotalDurationsDivisibleBy60 {

        @Override
        public int numPairsDivisibleBy60(int[] time) {
            int[] remainders = new int[60];
            for (int t : time) {
                remainders[t % 60]++;
            }
            int count = choose2(remainders[0]) + choose2(remainders[30]);
            for (int i = 1; i <= 29; i++) {
                count += remainders[i] * remainders[60 - i];
            }
            return count;
        }

        private int choose2(int n) {
            // C(n, 2) = n * (n - 1) / 2
            return n * (n - 1) / 2;
        }
    }

    public static class PairsOfSongsWithTotalDurationsDivisibleBy60CountingRemaindersRefactored extends PairsOfSongsWithTotalDurationsDivisibleBy60 {

        @Override
        public int numPairsDivisibleBy60(int[] time) {
            int[] remainders = new int[60];
            int count = 0;
            for (int t : time) {
                int remainder1 = t % 60;
                // count made pairs
                if (remainder1 % 60 == 0) {
                    count += remainders[0];
                } else {
                    int remainder2 = 60 - remainder1;
                    count += remainders[remainder2];
                }
                remainders[remainder1]++;
            }
            return count;
        }
    }
}
