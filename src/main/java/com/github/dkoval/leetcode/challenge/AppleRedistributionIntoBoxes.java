package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/apple-redistribution-into-boxes/">Apple Redistribution into Boxes</a>
 * <p>
 * You are given an array apple of size n and an array capacity of size m.
 * <p>
 * There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
 * <p>
 * Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
 * <p>
 * Note that, apples from the same pack can be distributed into different boxes.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == apple.length <= 50</li>
 *  <li>1 <= m == capacity.length <= 50</li>
 *  <li>1 <= apple[i], capacity[i] <= 50</li>
 *  <li>The input is generated such that it's possible to redistribute packs of apples into boxes.</li>
 * </ul>
 */
public interface AppleRedistributionIntoBoxes {

    int minimumBoxes(int[] apple, int[] capacity);

    class AppleRedistributionIntoBoxesRev1 implements AppleRedistributionIntoBoxes {

        @Override
        public int minimumBoxes(int[] apple, int[] capacity) {
            final var m = capacity.length;

            var apples = 0;
            for (var x : apple) {
                apples += x;
            }

            Arrays.sort(capacity);

            var boxes = 0;
            for (var i = m - 1; i >= 0 && apples > 0; i--) {
                apples -= Math.min(apples, capacity[i]);
                boxes++;
            }
            return boxes;
        }
    }
}
