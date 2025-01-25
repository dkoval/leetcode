package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/">Make Lexicographically Smallest Array by Swapping Elements</a>
 * <p>
 * You are given a 0-indexed array of positive integers nums and a positive integer limit.
 * <p>
 * In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
 * <p>
 * Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
 * <p>
 * An array a is lexicographically smaller than an array b if in the first position where a and b differ,
 * array a has an element that is less than the corresponding element in b.
 * For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.
 * <p>
 * Constraints:
 * <ul>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= limit <= 10^9
 */
public interface MakeLexicographicallySmallestArrayBySwappingElements {

    int[] lexicographicallySmallestArray(int[] nums, int limit);

    // Resource: https://youtu.be/-FGl6dzPexY?si=3N4CBlDnWLstO6N6
    class MakeLexicographicallySmallestArrayBySwappingElementsRev1 implements MakeLexicographicallySmallestArrayBySwappingElements {

        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            final var n = nums.length;

            // identify groups of numbers with contiguous elements satisfying the property:
            // |x[i] - x[i + 1]| <= limit
            final var copy = new IndexedValue[n];
            for (var i = 0; i < n; i++) {
                copy[i] = new IndexedValue(i, nums[i]);
            }
            Arrays.sort(copy, Comparator.comparingInt(it -> it.value));

            final var groups = new ArrayList<Deque<Integer>>();
            // index in nums[] -> group index
            final var lookup = new HashMap<Integer, Integer>();
            for (var i = 0; i < n; i++) {
                if (groups.isEmpty() || copy[i].value - groups.getLast().peekLast() > limit) {
                    // start a new group
                    groups.add(new ArrayDeque<>());
                }
                groups.getLast().offerLast(copy[i].value);
                lookup.put(copy[i].index, groups.size() - 1);
            }

            final var ans = new int[n];
            for (var i = 0; i < n; i++) {
                var gid = lookup.get(i);
                ans[i] = groups.get(gid).pollFirst();
            }
            return ans;
        }

        private record IndexedValue(int index, int value) {
        }
    }
}
