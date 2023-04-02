package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">Successful Pairs of Spells and Potions</a>
 * <p>
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 * <p>
 * You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
 * <p>
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == spells.length</li>
 *  <li>m == potions.length</li>
 *  <li>1 <= n, m <= 10^5</li>
 *  <li>1 <= spells[i], potions[i] <= 10^5</li>
 *  <li>1 <= success <= 10^10</li>
 * </ul>
 */
public interface SuccessfulPairsOfSpellsAndPotions {

    int[] successfulPairs(int[] spells, int[] potions, long success);

    class SuccessfulPairsOfSpellsAndPotionsRev1 implements SuccessfulPairsOfSpellsAndPotions {

        // O(M * logM + N * logM) = O((M + N) * logM) time | O(M + N) space
        @Override
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length;
            int m = potions.length;

            Arrays.sort(potions);
            int[] pairs = new int[n];
            for (int i = 0; i < n; i++) {
                // binary search
                // condition spells[i] * potions[i] will eventually become true
                // FF...FTT...T
                //       ^ <- find this idx, then the number of successful pairs = m - idx
                int left = 0;
                int right = m - 1;
                int idx = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if ((long) spells[i] * potions[mid] >= success) {
                        // mid might be the answer;
                        // check if there's a better option to the left of mid
                        idx = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                pairs[i] = (idx >= 0) ? m - idx : 0;
            }
            return pairs;
        }
    }
}
