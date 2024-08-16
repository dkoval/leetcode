package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-distance-in-arrays">Maximum Distance in Arrays</a>
 * <p>
 * You are given m arrays, where each array is sorted in ascending order.
 * <p>
 * You can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a - b|.
 * <p>
 * Return the maximum distance.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == arrays.length</li>
 *  <li>2 <= m <= 105</li>
 *  <li>1 <= arrays[i].length <= 500</li>
 *  <li>-104 <= arrays[i][j] <= 10^4</li>
 *  <li>arrays[i] is sorted in ascending order</li>
 *  <li>There will be at most 10^5 integers in all the arrays</li>
 * </ul>
 */
public interface MaximumDistanceInArrays {

    int maxDistance(List<List<Integer>> arrays);

    class MaximumDistanceInArraysRev1 implements MaximumDistanceInArrays {

        @Override
        public int maxDistance(List<List<Integer>> arrays) {
            if (arrays.size() < 2) {
                return 0;
            }


            // [..], [..], ... | [ curr_min .. curr_max], ...
            //                     ^               ^
            // < -------------->
            // fetch min and max seen so far in O(1) time
            int best = 0;
            int minSoFar = arrays.getFirst().getFirst();
            int maxSoFar = arrays.getFirst().getLast();
            for (int i = 1; i < arrays.size(); i++) {
                int currMin = arrays.get(i).getFirst();
                int currMax = arrays.get(i).getLast();

                best = Math.max(best, currMax - minSoFar);
                best = Math.max(best, maxSoFar - currMin);

                minSoFar = Math.min(minSoFar, currMin);
                maxSoFar = Math.max(maxSoFar, currMax);
            }
            return best;
        }
    }
}
