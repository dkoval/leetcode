package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/">Minimum Swaps to Sort by Digit Sum</a>
 * <p>
 * You are given an array nums of distinct positive integers. You need to sort the array in increasing order based on the sum of the digits of each number.
 * If two numbers have the same digit sum, the smaller number appears first in the sorted order.
 * <p>
 * Return the minimum number of swaps required to rearrange nums into this sorted order.
 * <p>
 * A swap is defined as exchanging the values at two distinct positions in the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>nums consists of distinct positive integers.</li>
 * </ul>
 */
public interface MinimumSwapsToSortByDigitSum {

    int minSwaps(int[] nums);

    class MinimumSwapsToSortByDigitSumRev1 implements MinimumSwapsToSortByDigitSum {

        @Override
        public int minSwaps(int[] nums) {
            final var n = nums.length;

            final var arr = new IndexedValue[n];
            for (var i = 0; i < n; i++) {
                arr[i] = new IndexedValue(i, nums[i]);
            }

            Arrays.sort(arr, (x, y) -> {
                final var digitSumX = digitSum(x.value);
                final var digitSumY = digitSum(y.value);
                return (digitSumX == digitSumY) ? Integer.compare(x.value, y.value) : Integer.compare(digitSumX, digitSumY);
            });

            var count = 0;
            for (var i = 0; i < n; i++) {
                while (i != arr[i].index) {
                    swap(arr, i, arr[i].index);
                    count++;
                }
            }
            return count;
        }

        private int digitSum(int x) {
            var sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }

        private void swap(Object[] nums, int i, int j) {
            final var tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private record IndexedValue(
                int index,
                int value
        ) {
        }
    }
}
