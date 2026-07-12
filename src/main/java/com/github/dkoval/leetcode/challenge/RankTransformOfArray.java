package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/rank-transform-of-an-array/">Rank Transform of an Array</a>
 * <p>
 * Given an array of integers arr, replace each element with its rank.
 * <p>
 * The rank represents how large the element is. The rank has the following rules:
 * <p>
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= arr.length <= 10^5</li>
 *  <li>-10^9 <= arr[i] <= 10^9</li>
 * </ul>
 */
public interface RankTransformOfArray {

    int[] arrayRankTransform(int[] arr);

    class RankTransformOfArrayRev1 implements RankTransformOfArray {

        @Override
        public int[] arrayRankTransform(int[] arr) {
            final var n = arr.length;

            final var items = new IndexedValue[n];
            for (var i = 0; i < n; i++) {
                items[i] = new IndexedValue(i, arr[i]);
            }

            Arrays.sort(items, Comparator.comparingInt(IndexedValue::value));

            var rank = 1;
            final var ans = new int[n];
            for (var i = 0; i < n; i++) {
                if (i > 0 && items[i].value > items[i - 1].value) {
                    rank++;
                }
                ans[items[i].index] = rank;
            }
            return ans;
        }

        private record IndexedValue(int index, int value) {
        }
    }
}
