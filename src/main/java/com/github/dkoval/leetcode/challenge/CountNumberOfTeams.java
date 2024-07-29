package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-number-of-teams/">Count Number of Teams</a>
 * <p>
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * <p>
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * <ul>
 * <li>Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).</li>
 * <li>A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).</li>
 * </ul>
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == rating.length</li>
 *  <li>3 <= n <= 1000</li>
 *  <li>1 <= rating[i] <= 10^5</li>
 *  <li>All the integers in rating are unique.</li>
 * </ul>
 */
public interface CountNumberOfTeams {

    int numTeams(int[] rating);

    // O(N^2) | O(N) space
    class CountNumberOfTeamsRev1 implements CountNumberOfTeams {

        @Override
        public int numTeams(int[] rating) {
            int n = rating.length;

            // Scenario #1: rating[i] < rating[j] < rating[k]
            // for any middle number x, the number of teams that can be formed:
            // count(numbers to the left of x that are < x) * count(numbers to the right of x that are > x) = Cl * Cb
            //
            // Scenario #2: rating[i] > rating[j] > rating[k]
            // for any middle number x, the number of teams that can be formed:
            // count(numbers to the left of x that are > x) * count(numbers to the right of x that are < x)
            // = (j - Cl) * (n - 1 - j - Cb)
            int[] lesser = new int[n]; // lesser[j] - count numbers to the left of j that are < rating[j]
            int[] bigger = new int[n]; // bigger[j] - count numbers to the right of j that are > rating[j]
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < j; i++) {
                    if (rating[i] < rating[j]) {
                        lesser[j]++;
                    }
                }

                for (int k = j + 1; k < n; k++) {
                    if (rating[k] > rating[j]) {
                        bigger[j]++;
                    }
                }
            }

            int total = 0;
            for (int j = 1; j < n; j++) {
                total += lesser[j] * bigger[j];
                total += (j - lesser[j]) * (n - 1 - j - bigger[j]);
            }
            return total;
        }
    }
}
