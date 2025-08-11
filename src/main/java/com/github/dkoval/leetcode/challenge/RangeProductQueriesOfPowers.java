package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/range-product-queries-of-powers/">Range Product Queries of Powers</a>
 * <p>
 * Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n.
 * The array is sorted in non-decreasing order, and there is only one way to form the array.
 * <p>
 * You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti].
 * Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.
 * <p>
 * Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query.
 * Since the answer to the ith query may be too large, each answers[i] should be returned modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^9</li>
 *  <li>1 <= queries.length <= 10^5</li>
 *  <li>0 <= starti <= endi < powers.length</li>
 * </ul>
 */
public interface RangeProductQueriesOfPowers {

    int MOD = 1_000_000_007;

    int[] productQueries(int n, int[][] queries);

    class RangeProductQueriesOfPowersRev1 implements RangeProductQueriesOfPowers {

        @Override
        public int[] productQueries(int n, int[][] queries) {
            final var powers = new ArrayList<Integer>();
            var i = 0;
            while (n != 0) {
                final var lsb = n & 1;
                if (lsb != 0) {
                    powers.add(1 << i);
                }
                n >>= 1;
                i++;
            }


            final var ans = new int[queries.length];
            var index = 0;
            for (var query : queries) {
                var product = 1L;
                for (var j = query[0]; j <= query[1]; j++) {
                    product *= powers.get(j);
                    product %= MOD;
                }
                ans[index++] = (int) product;
            }
            return ans;
        }
    }
}
