package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/closest-equal-element-queries">Closest Equal Element Queries</a>
 * <p>
 * You are given a circular array nums and an array queries.
 * <p>
 * For each query i, you have to find the following:
 * <p>
 * The minimum distance between the element at index queries[i] and any other index j in the circular array,
 * where nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
 * <p>
 * Return an array answer of the same size as queries, where answer[i] represents the result for query i.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= queries.length <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 *  <li>0 <= queries[i] < nums.length</li>
 * </ul>
 */
public interface ClosestEqualElementQueries {

    List<Integer> solveQueries(int[] nums, int[] queries);

    class ClosestEqualElementQueriesRev1 implements ClosestEqualElementQueries {

        @Override
        public List<Integer> solveQueries(int[] nums, int[] queries) {
            final var n = nums.length;
            final var q = queries.length;

            // step 1: preprocess unique elements in nums[]
            var uniq = new HashMap<Integer, List<Integer>>();
            for (var i = 0; i < n; i++) {
                uniq.computeIfAbsent(nums[i], __ -> new ArrayList<>()).add(i);
            }

            if (uniq.size() == 1) {
                final var indexes = uniq.values().iterator().next();
                return (indexes.size() > 1) ? Collections.nCopies(q, 1) : Collections.singletonList(-1);
            }

            // step 2: process queries
            final var res = new ArrayList<Integer>();
            for (var query : queries) {
                final var dist = closestDist(query, uniq.get(nums[query]), n);
                res.add(dist < n ? dist : -1);
            }
            return res;
        }

        private int closestDist(int startIndex, List<Integer> indexes, int n) {
            var best = n;
            for (var i : indexes) {
                if (i == startIndex) {
                    continue;
                }

                final var dist = Math.abs(i - startIndex);
                best = Math.min(best, dist);
                best = Math.min(best, n - dist);
            }
            return best;
        }
    }
}
