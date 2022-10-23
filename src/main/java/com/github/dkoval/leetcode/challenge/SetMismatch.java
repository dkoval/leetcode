package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/set-mismatch/">Set Mismatch</a>
 * <p>
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
 * one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and
 * loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 10^4</li>
 *  <li>1 <= nums[i] <= 10^4</li>
 * </ul>
 */
public abstract class SetMismatch {

    public abstract int[] findErrorNums(int[] nums);

    // O(N) time | O(N) space
    public static class SetMismatchNaive extends SetMismatch {

        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            Set<Integer> seen = new HashSet<>();

            // ans[0] - duplicate, ans[1] - missing
            int[] ans = new int[2];
            // record the sum of non-repeatable numbers
            int sumOfUnique = 0;
            for (int x : nums) {
                if (seen.contains(x)) {
                    ans[0] = x;
                } else {
                    sumOfUnique += x;
                    seen.add(x);
                }
            }

            // 1 + 2 + ... + n = n * (n + 1) / 2
            ans[1] = n * (n + 1) / 2 - sumOfUnique;
            return ans;
        }
    }

    // O(N) time | O(1) space
    public static class SetMismatchOptimal extends SetMismatch {

        // Resource: https://www.youtube.com/watch?v=u6Dt9av66yM
        @Override
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            // ans[0] - duplicate, ans[1] - missing
            int[] ans = new int[2];

            // 1st pass - find the duplicate number
            for (int x : nums) {
                int i = Math.abs(x) - 1; // map x to index
                if (nums[i] < 0) {
                    ans[0] = i + 1;
                } else {
                    // mark x as visited
                    nums[i] *= -1;
                }
            }

            // 2nd pass - find the missing number
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    ans[1] = i + 1;
                    break;
                }
            }
            return ans;
        }
    }
}
