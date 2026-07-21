package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/maximize-active-section-with-trade-i/">Maximize Active Section with Trade I</a>
 * <p>
 * You are given a binary string s of length n, where:
 * <ul>
 *  <li>'1' represents an active section.</li>
 *  <li>'0' represents an inactive section.</li>
 * </ul>
 * You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
 * <ul>
 *  <li>Convert a contiguous block of '1's that is surrounded by '0's to all '0's.</li>
 *  <li>Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.</li>
 * </ul>
 * Return the maximum number of active sections in s after making the optimal trade.
 * <p>
 * Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'.
 * The augmented '1's do not contribute to the final count.
 */
public interface MaximizeActiveSectionWithTrade1 {

    int maxActiveSectionsAfterTrade(String s);

    class MaximizeActiveSectionWithTrade1Rev1 implements MaximizeActiveSectionWithTrade1 {

        @Override
        public int maxActiveSectionsAfterTrade(String s) {
            final var n = s.length();

            final var blocksOfZeros = new ArrayList<Integer>();
            var ones = 0;
            var right = 0;
            while (right < n) {
                if (s.charAt(right) == '0') {
                    final var left = right;
                    right++;
                    while (right < n && s.charAt(right) == '0') {
                        right++;
                    }
                    blocksOfZeros.add(right - left);
                } else {
                    ones++;
                    right++;
                }
            }

            // check every pair of consecutive blocks of 0's
            // 00 ... 0000 ... 000
            var best = 0;
            for (var i = 1; i < blocksOfZeros.size(); i++) {
                best = Math.max(best, blocksOfZeros.get(i) + blocksOfZeros.get(i - 1));
            }
            return best + ones;
        }
    }
}
