package com.github.dkoval.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/">Minimum Number of Days to Make m Bouquets</a>
 * <p>
 * You are given an integer array bloomDay, an integer m and an integer k.
 * <p>
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * <p>
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * <p>
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>bloomDay.length == n</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= bloomDay[i] <= 10^9</li>
 *  <li>1 <= m <= 10^6</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface MinimumNumberOfDaysToMakeMBouquets {

    int minDays(int[] bloomDay, int m, int k);

    class MinimumNumberOfDaysToMakeMBouquetsUsingBinarySearchRev1 implements MinimumNumberOfDaysToMakeMBouquets {

        private static final int MAX_DAY = 1_000_000_000;

        @Override
        public int minDays(int[] bloomDay, int m, int k) {
            int n = bloomDay.length;
            if (n < m * k) {
                return -1;
            }

            // Can make >= m bouquets at day x?
            // If that is true at day x, it is also true at any day y > x
            // FF...FTT...T
            //       ^ answer (lower boundary)
            int left = 1;
            int right = MAX_DAY;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (makeBouquets(bloomDay, k, mid) >= m) {
                    // mid might be the answer;
                    // check if there is a better option to the left of it
                    right = mid;
                } else {
                    // mid is not the answer + everything to the left of it
                    left = mid + 1;
                }
            }
            return (left > MAX_DAY) ? -1 : left;
        }

        private int makeBouquets(int[] bloomDay, int k, int day) {
            // count how bouquets consisting of k adjacent flowers we can make at day x
            int n = bloomDay.length;
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= day) {
                    indices.add(i);
                }
            }

            int count = 0;
            int i = 0;
            while (i < indices.size()) {
                // starting from index i, count adjacent flowers
                int j = i + 1;
                while (j < indices.size() && indices.get(j) == indices.get(j - 1) + 1) {
                    j++;
                }
                // how many new bouquets did we make?
                count += (j - i) / k;
                i = j;
            }
            return count;
        }
    }
}
