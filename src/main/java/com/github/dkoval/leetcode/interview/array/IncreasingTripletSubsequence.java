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
public interface IncreasingTripletSubsequence {

    boolean increasingTriplet(int[] nums);

    // O(N) time | O(N) space
    class IncreasingTripletSubsequenceUsingExtraSpace implements IncreasingTripletSubsequence {

        @Override
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return false;
            }

            // minLeft[i] = min(nums[0], ..., nums[i])
            int[] minLeft = new int[n];
            // maxRight[i] = max(nums[i - 1], ..., nums[i])
            int[] maxRight = new int[n];

            for (int i = 0; i < n; i++) {
                minLeft[i] = Math.min(i > 0 ? minLeft[i - 1] : Integer.MAX_VALUE, nums[i]);
                maxRight[n - i - 1] = Math.max(n - i < n ? maxRight[n - i] : Integer.MIN_VALUE, nums[n - i - 1]);
            }

            // check if there exists index i in nums[] such that minLeft[i] < nums[i] < maxRight[i]
            for (int i = 0; i < n; i++) {
                if (nums[i] > minLeft[i] && nums[i] < maxRight[i]) {
                    return true;
                }
            }
            return false;
        }
    }

    // O(N) time | O(1) space
    class IncreasingTripletSubsequenceWithoutExtraSpace implements IncreasingTripletSubsequence {

        @Override
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) return false;
            // The idea is to keep track of the first two numbers in increasing order and
            // find the last number which will be bigger than the first two numbers, i,e.
            // first < second < nums[i]
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
}
