package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/">Binary Trees With Factors</a>
 * <p>
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 * <p>
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 */
public class BinaryTreesWithFactors {

    private static final int MOD = 1_000_000_000 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Set<Integer> factors = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        long count = 0;
        Map<Integer, Long> memo = new HashMap<>();
        for (int rootVal : factors) {
            count += numRootedTrees(rootVal, factors, memo);
            count %= MOD;
        }
        return (int) count;
    }

    private long numRootedTrees(int rootVal, Set<Integer> factors, Map<Integer, Long> memo) {
        if (memo.containsKey(rootVal)) {
            return memo.get(rootVal);
        }
        long count = 1;
        for (int leftVal : factors) {
            if (rootVal % leftVal == 0) {
                int rightVal = rootVal / leftVal;
                if (factors.contains(rightVal)) {
                    count += numRootedTrees(leftVal, factors, memo) * numRootedTrees(rightVal, factors, memo);
                    count %= MOD;
                }
            }
        }
        memo.put(rootVal, count);
        return count;
    }
}
