package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/">Sort Integers by The Number of 1 Bits</a>
 * <p>
 * You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's
 * in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 * <p>
 * Return the array after sorting it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 500</li>
 *  <li>0 <= arr[i] <= 10^4</li>
 * </ul>
 */
public interface SortIntegersByNumberOf1Bits {

    int[] sortByBits(int[] arr);

    class SortIntegersByNumberOf1BitsRev1 implements SortIntegersByNumberOf1Bits {

        @Override
        public int[] sortByBits(int[] arr) {
            final var nums = fromPrimitiveArray(arr);
            Arrays.sort(nums, (x, y) -> {
                final var count1 = countBits(x);
                final var count2 = countBits(y);
                return (count1 != count2) ? Integer.compare(count1, count2) : Integer.compare(x, y);
            });
            return toPrimitiveArray(nums);
        }

        private Integer[] fromPrimitiveArray(int[] arr) {
            return Arrays.stream(arr).boxed().toArray(Integer[]::new);
        }

        private int[] toPrimitiveArray(Integer[] arr) {
            return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        }

        private int countBits(int x) {
            var count = 0;
            while (x > 0) {
                count += x & 1;
                x >>= 1;
            }
            return count;
        }
    }
}
