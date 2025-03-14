package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-candies-allocated-to-k-children/">Maximum Candies Allocated to K Children</a>
 * <p>
 * You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i].
 * You can divide each pile into any number of sub piles, but you cannot merge two piles together.
 * <p>
 * You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies.
 * Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.
 * <p>
 * Return the maximum number of candies each child can get.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= candies.length <= 10^5</li>
 *  <li>1 <= candies[i] <= 10^7</li>
 *  <li>1 <= k <= 10^12</li>
 * </ul>
 */
public interface MaximumCandiesAllocatedToKChildren {

    int maximumCandies(int[] candies, long k);

    class MaximumCandiesAllocatedToKChildrenRev1 implements MaximumCandiesAllocatedToKChildren {

        @Override
        public int maximumCandies(int[] candies, long k) {
            final var n = candies.length;

            var total = 0L;
            var max = 1;
            for (var x : candies) {
                total += x;
                max = Math.max(max, x);
            }

            if (total < k) {
                return 0;
            }

            // Binary search the maximum number of candies each child can get
            // TT...TFF...F
            //      ^ answer
            var left = 1;
            var right = max;
            while (left < right) {
                var mid = left + (right - left + 1) / 2;
                if (good(candies, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean good(int[] candies, long k, int target) {
            var count = 0L;
            for (var x : candies) {
                count += x / target;
            }
            return count >= k;
        }
    }
}
