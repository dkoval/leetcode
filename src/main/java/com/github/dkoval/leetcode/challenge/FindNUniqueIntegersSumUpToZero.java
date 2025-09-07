package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/">Find N Unique Integers Sum up to Zero</a>
 * <p>
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public interface FindNUniqueIntegersSumUpToZero {

    int[] sumZero(int n);

    class FindNUniqueIntegersSumUpToZeroRev1 implements FindNUniqueIntegersSumUpToZero {

        @Override
        public int[] sumZero(int n) {
            final var ans = new int[n];

            var index = 0;
            for (var x = 1; x <= n / 2; x++) {
                ans[index] = x;
                ans[index + 1] = -x;
                index += 2;
            }

            if (n % 2 != 0) {
                ans[n - 1] = 0;
            }

            return ans;
        }
    }

    class FindNUniqueIntegersSumUpToZeroRev2 implements FindNUniqueIntegersSumUpToZero {

        @Override
        public int[] sumZero(int n) {
            final var ans = new int[n];

            var left = 0;
            var right = n - 1;
            var x = 1;
            while (left < right) {
                ans[left++] = -x;
                ans[right--] = x;
                x++;
            }
            // if n is odd, the middle element is 0
            return ans;
        }
    }
}
