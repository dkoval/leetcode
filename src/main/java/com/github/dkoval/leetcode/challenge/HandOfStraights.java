package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/hand-of-straights/">Hand of Straights</a>
 * <p>
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize,
 * and consists of groupSize consecutive cards.
 * <p>
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= hand.length <= 10^4</li>
 *  <li>0 <= hand[i] <= 109</li>
 *  <li>1 <= groupSize <= hand.length</li>
 * </ul>
 */
public interface HandOfStraights {

    boolean isNStraightHand(int[] hand, int groupSize);

    class HandOfStraightsRev1 implements HandOfStraights {

        @Override
        public boolean isNStraightHand(int[] hand, int groupSize) {
            int n = hand.length;

            if (n % groupSize != 0) {
                return false;
            }

            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : hand) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            // sort numbers in ASC order to efficiently identify groups
            Arrays.sort(hand);
            for (int start : hand) {
                int count = counts.get(start);
                if (count == 0) {
                    continue;
                }

                // hand[i] is the 1st element of a new group, potentially;
                // check if there's enough consecutive numbers
                counts.put(start, count - 1);
                for (int x = start + 1; x < start + groupSize; x++) {
                    count = counts.getOrDefault(x, 0);
                    if (count == 0) {
                        return false;
                    }
                    counts.put(x, count - 1);
                }
            }
            return true;
        }
    }
}
