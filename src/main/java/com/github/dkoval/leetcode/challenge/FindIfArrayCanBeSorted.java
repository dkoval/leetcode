package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-if-array-can-be-sorted/">Find if Array Can Be Sorted</a>
 * <p>
 * You are given a 0-indexed array of positive integers nums.
 * <p>
 * In one operation, you can swap any two adjacent elements if they have the same number of
 * set bits
 * . You are allowed to do this operation any number of times (including zero).
 * <p>
 * Return true if you can sort the array, else return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i] <= 28</li>
 * </ul>
 */
public interface FindIfArrayCanBeSorted {

    boolean canSortArray(int[] nums);

    class FindIfArrayCanBeSortedRev1 implements FindIfArrayCanBeSorted {

        @Override
        public boolean canSortArray(int[] nums) {
            int n = nums.length;

            if (n == 1) {
                return true;
            }

            // Idea: split nums[] into segments.
            // Each segment contains consecutive elements of nums[] having the same number of set bits.
            // For each segment, record its min and max elements.
            // nums[] can be sorted IFF the i-th segment's max < the (i + 1)-th segment's max.
            Segment prev = null;
            int i = 0;
            while (i < n) {
                Segment curr = new Segment(Integer.bitCount(nums[i]));
                curr.min = nums[i];
                curr.max = nums[i];
                i++;
                while (i < n && Integer.bitCount(nums[i]) == curr.setBits) {
                    curr.min = Math.min(curr.min, nums[i]);
                    curr.max = Math.max(curr.max, nums[i]);
                    i++;
                }

                // the previous segment’s max element should be smaller than the current segment’s min element
                if (prev != null && prev.max > curr.min) {
                    return false;
                }
                prev = curr;
            }
            return true;
        }

        private static class Segment {
            final int setBits;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            Segment(int setBits) {
                this.setBits = setBits;
            }

            @Override
            public String toString() {
                return String.format("setBits = %d, min = %d, max = %d", setBits, min, max);
            }
        }
    }
}
