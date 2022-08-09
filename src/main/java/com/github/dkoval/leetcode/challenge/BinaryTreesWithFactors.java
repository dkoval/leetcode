package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/binary-trees-with-factors/">Binary Trees With Factors</a>
 * <p>
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 * <p>
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 1000</li>
 *  <li>2 <= arr[i] <= 10^9</li>
 *  <li>All the values of arr are unique</li>
 * </ul>
 */
public class BinaryTreesWithFactors {

    private static final int MOD = 1_000_000_000 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Set<Integer> factors = new HashSet<>();
        for (int x : arr) {
            factors.add(x);
        }

        // memo[x] - is the number of factored binary trees with root x
        Map<Integer, Long> memo = new HashMap<>();
        long count = 0;
        for (int root : factors) {
            count += countFactoredBinTrees(root, factors, memo);
            count %= MOD;
        }
        return (int) count;
    }

    private long countFactoredBinTrees(int root, Set<Integer> factors, Map<Integer, Long> memo) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        long count = 1;
        for (int left : factors) {
            if (root % left == 0) {
                int right = root / left;
                if (factors.contains(right)) {
                    count += countFactoredBinTrees(left, factors, memo) * countFactoredBinTrees(right, factors, memo);
                    count %= MOD;
                }
            }
        }

        memo.put(root, count);
        return count;
    }
}
