package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/tuple-with-same-product/">Tuple with Same Product</a>
 * <p>
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that
 * a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 104</li>
 *  <li>All elements in nums are distinct.</li>
 * </ul>
 */
public interface TupleWithSameProduct {

    int tupleSameProduct(int[] nums);

    class TupleWithSameProductRev1 implements TupleWithSameProduct {

        @Override
        public int tupleSameProduct(int[] nums) {
            final var n = nums.length;

            // product x * y -> number of pairs
            final var products = new HashMap<Integer, Integer>();
            for (var i = 0; i < n - 1; i++) {
                for (var j = i + 1; j < n; j++) {
                    var p = nums[i] * nums[j];
                    products.put(p, products.getOrDefault(p, 0) + 1);
                }
            }

            var total = 0;
            for (var numPairs : products.values()) {
                total += numPairs * (numPairs - 1) * 4;
            }
            return total;
        }
    }
}
