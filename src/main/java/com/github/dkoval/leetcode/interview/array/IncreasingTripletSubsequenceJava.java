package com.github.dkoval.leetcode.interview.array;

/**
 * <a href="https://leetcode.com/problems/increasing-triplet-subsequence/">Increasing Triplet Subsequence</a>
 * <p>
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * <p>
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class IncreasingTripletSubsequenceJava {

    // Time complexity: O(N), space complexity: O(1)
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        // The idea is to keep track of the first two numbers in increasing order and
        // find the last number which will be bigger than the first two numbers.
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            } else if (num > second) {
                return true;
            }
        }
        return false;
    }
}
