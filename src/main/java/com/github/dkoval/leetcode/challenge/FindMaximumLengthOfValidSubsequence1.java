package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/">Find the Maximum Length of Valid Subsequence I</a>
 * <p>
 * You are given an integer array nums.
 * A subsequence sub of nums with length x is called valid if it satisfies:
 * <p>
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
 * <p>
 * Return the length of the longest valid subsequence of nums.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= nums.length <= 2 * 10^5</li>
 *  <li>1 <= nums[i] <= 10^7</li>
 * </ul>
 */
public interface FindMaximumLengthOfValidSubsequence1 {

    int maximumLength(int[] nums);

    class FindMaximumLengthOfValidSubsequence1Rev1 implements FindMaximumLengthOfValidSubsequence1 {

        @Override
        public int maximumLength(int[] nums) {
            // (x + y) % 2 = 0 or 1
            // Possible subsequences:
            // 1. All elements are even.
            // 2. All elements are odd.
            // 3. Parity of elements is alternating, i.e.
            // 3.1 even, odd, even, odd, ...
            // 3.2 odd, even, odd, even, ...

            // same parity
            var subseqWithAllEvens = 0;
            var subseqWithAllOdds = 0;
            for (var x : nums) {
                if (x % 2 == 0) {
                    subseqWithAllEvens++;
                } else {
                    subseqWithAllOdds++;
                }
            }

            var best = Math.max(subseqWithAllEvens, subseqWithAllOdds);

            // alternating parity
            var subseqEndingWithEven = 0;
            var subseqEndingWithOdd = 0;
            for (var x : nums) {
                if (x % 2 == 0) {
                    subseqEndingWithEven = Math.max(subseqEndingWithEven, subseqEndingWithOdd + 1);
                } else {
                    subseqEndingWithOdd = Math.max(subseqEndingWithOdd, subseqEndingWithEven + 1);
                }
            }

            best = Math.max(best, subseqEndingWithEven);
            best = Math.max(best, subseqEndingWithOdd);
            return best;
        }
    }

    class FindMaximumLengthOfValidSubsequence1Rev2 implements FindMaximumLengthOfValidSubsequence1 {

        @Override
        public int maximumLength(int[] nums) {
            // (x + y) % 2 = 0 or 1
            // Possible subsequences:
            // 1. All elements are even.
            // 2. All elements are odd.
            // 3. Parity of elements is alternating, i.e.
            // 3.1 even, odd, even, odd, ...
            // 3.2 odd, even, odd, even, ...

            var subseqWithAllEvens = 0;
            var subseqWithAllOdds = 0;
            var subseqEndingWithEven = 0;
            var subseqEndingWithOdd = 0;
            for (var x : nums) {
                if (x % 2 == 0) {
                    subseqWithAllEvens++;
                    subseqEndingWithEven = Math.max(subseqEndingWithEven, subseqEndingWithOdd + 1);
                } else {
                    subseqWithAllOdds++;
                    subseqEndingWithOdd = Math.max(subseqEndingWithOdd, subseqEndingWithEven + 1);
                }
            }

            var best = Math.max(subseqWithAllEvens, subseqWithAllOdds);
            best = Math.max(best, subseqEndingWithEven);
            best = Math.max(best, subseqEndingWithOdd);
            return best;
        }
    }
}
