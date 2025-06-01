package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/distribute-candies-among-children-ii/">Distribute Candies Among Children II</a>
 * <p>
 * You are given two positive integers n and limit.
 * <p>
 * Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^6</li>
 *  <li>1 <= limit <= 10^6</li>
 * </ul>
 */
public interface DistributeCandiesAmongChildren2 {

    long distributeCandies(int n, int limit);

    class DistributeCandiesAmongChildren2Rev1 implements DistributeCandiesAmongChildren2 {

        @Override
        public long distributeCandies(int n, int limit) {
            if (n > limit * 3) {
                // too many candies to distribute among 3 children
                return 0L;
            }

            var total = 0L;
            for (var i = 0; i <= Math.min(n, limit); i++) {
                // given the limit, how many ways are there to distribute n - i candies among 2 children?
                var candiesToDistribute = n - i;
                if (limit >= candiesToDistribute) {
                    total += candiesToDistribute + 1;
                } else {
                    // Example: n = 10, limit = 6
                    // j  | k
                    // 1  | 9 -+
                    // 2  | 8  | exceed the limit for k
                    // 3  | 7 -+
                    // 4  | 6
                    // 5  | 5
                    // 6  | 4
                    // 7  | 3 -+
                    // 8  | 2  | exceed the limit for j
                    // 9  | 1  |
                    // 10 | 0 -+
                    // Valid range is [candiesToDistribute - limit .. limit]
                    total += Math.max(limit - (candiesToDistribute - limit) + 1, 0);
                }
            }
            return total;
        }
    }
}
