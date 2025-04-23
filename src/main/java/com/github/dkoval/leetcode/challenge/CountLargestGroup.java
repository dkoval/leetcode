package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/count-largest-group/">Count Largest Group</a>
 * <p>
 * You are given an integer n.
 * <p>
 * Each number from 1 to n is grouped according to the sum of its digits.
 * <p>
 * Return the number of groups that have the largest size.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 */
public interface CountLargestGroup {

    int countLargestGroup(int n);

    class CountLargestGroupRev1 implements CountLargestGroup {

        @Override
        public int countLargestGroup(int n) {
            var bestSize = 0;
            var count = 0;
            // sum of digits -> size of a group
            final var groups = new HashMap<Integer, Integer>();
            for (var x = 1; x <= n; x++) {
                final var sumOfDigits = sumDigits(x);
                final var size = groups.getOrDefault(sumOfDigits, 0) + 1;
                if (size == bestSize) {
                    count++;
                } else if (size > bestSize) {
                    bestSize = size;
                    count = 1;
                }
                groups.put(sumOfDigits, size);
            }
            return count;
        }

        private int sumDigits(int x) {
            var sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }
    }

    class CountLargestGroupRev2 implements CountLargestGroup {

        @Override
        public int countLargestGroup(int n) {
            var bestSize = 0;
            var count = 0;
            // sum of digits -> size of a group
            // given 1 <= n <= 10^4, the largest sum we can get is 9 + 9 + 9 + 9 = 36
            final var groups = new int[37];
            for (var x = 1; x <= n; x++) {
                final var size = ++groups[sumDigits(x)];
                if (size == bestSize) {
                    count++;
                } else if (size > bestSize) {
                    bestSize = size;
                    count = 1;
                }
            }
            return count;
        }

        private int sumDigits(int x) {
            var sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }
    }
}
