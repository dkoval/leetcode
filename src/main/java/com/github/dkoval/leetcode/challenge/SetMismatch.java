package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/">Set Mismatch</a>
 * <p>
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
 * one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and
 * loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
public abstract class SetMismatch {

    public abstract int[] findErrorNums(int[] nums);

    // O(N) time | O(N) space
    public static class SetMismatchNaive extends SetMismatch {

        public int[] findErrorNums(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            int[] answer = new int[2];
            // 1 + 2 + ... + n = n * (n + 1) / 2
            int sum = 0;
            for (int num : nums) {
                if (seen.contains(num)) {
                    answer[0] = num;
                } else {
                    sum += num;
                    seen.add(num);
                }
            }
            answer[1] = nums.length * (nums.length + 1) / 2 - sum;
            return answer;
        }
    }

    // O(N) time | O(1) space
    public static class SetMismatchOptimal extends SetMismatch {

        // Resource: https://www.youtube.com/watch?v=u6Dt9av66yM&t=338s
        @Override
        public int[] findErrorNums(int[] nums) {
            int[] answer = new int[2];
            // 1st pass - find the duplicate number
            for (int num : nums) {
                int i = Math.abs(num) - 1; // map num to index
                if (nums[i] < 0) {
                    answer[0] = i + 1;
                } else {
                    nums[i] *= -1; // convert to negative
                }
            }
            // 2nd pass - find the missing number
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    answer[1] = i + 1;
                    break;
                }
            }
            return answer;
        }
    }
}
