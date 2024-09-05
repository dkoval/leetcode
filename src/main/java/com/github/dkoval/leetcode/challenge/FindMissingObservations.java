package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-missing-observations/">Find Missing Observations</a>
 * <p>
 * You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing,
 * and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.
 * <p>
 * You are given an integer array rolls of length m where rolls[i] is the value of the ith observation.
 * You are also given the two integers mean and n.
 * <p>
 * Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean.
 * If there are multiple valid answers, return any of them. If no such array exists, return an empty array.
 * <p>
 * The average value of a set of k numbers is the sum of the numbers divided by k.
 * <p>
 * Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == rolls.length</li>
 *  <li>1 <= n, m <= 10^5</li>
 *  <li>1 <= rolls[i], mean <= 6</li>
 * </ul>
 */
public interface FindMissingObservations {

    int[] missingRolls(int[] rolls, int mean, int n);

    class FindMissingObservationsRev1 implements FindMissingObservations {

        @Override
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length;

            int observableSum = 0;
            for (int x : rolls) {
                observableSum += x;
            }

            int missingSum = mean * (n + m) - observableSum;

            // 1 <= each roll <= 6
            // n <= sum of n rolls <= 6 * n
            if (missingSum < n || missingSum > 6 * n) {
                return new int[0];
            }

            // distribute equally
            // missing sum = p * n + q, where 0 <= q <= (p - 1)
            int[] ans = new int[n];
            int p = missingSum / n;
            int q = missingSum % n;

            Arrays.fill(ans, p);
            int i = 0;
            while (q > 0) {
                q--;
                ans[i]++;
                i++;
            }
            return ans;
        }
    }
}
