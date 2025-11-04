package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/">Find X-Sum of All K-Long Subarrays I</a>
 * <p>
 * You are given an array nums of n integers and two integers k and x.
 * <p>
 * The x-sum of an array is calculated by the following procedure:
 * <ul>
 *  <li>Count the occurrences of all elements in the array.</li>
 *  <li>Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.</li>
 *  <li>Calculate the sum of the resulting array.</li>
 * </ul>
 * Note that if an array has less than x distinct elements, its x-sum is the sum of the array.
 * <p>
 * Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == nums.length <= 50</li>
 *  <li>1 <= nums[i] <= 50</li>
 *  <li>1 <= x <= k <= nums.length</li>
 * </ul>
 */
public interface FindXSumOfAllKLongSubarrays1 {

    int[] findXSum(int[] nums, int k, int x);

    class FindXSumOfAllKLongSubarrays1Rev1 implements FindXSumOfAllKLongSubarrays1 {

        @Override
        public int[] findXSum(int[] nums, int k, int x) {
            final var n = nums.length;

            final var ans = new int[n - k + 1];
            for (var i = 0; i <= n - k; i++) {
                ans[i] = xSum(nums, i, i + k - 1, x);
            }
            return ans;
        }

        private int xSum(int[] nums, int left, int right, int x) {
            final var counts = new HashMap<Integer, Integer>();
            for (var i = left; i <= right; i++) {
                final var num = nums[i];
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }

            final var xs = new ArrayList<NumWithFrequency>(counts.size());
            for (var entry : counts.entrySet()) {
                xs.add(new NumWithFrequency(entry.getKey(), entry.getValue()));
            }

            xs.sort((x1, x2) -> {
                return (x1.frequency == x2.frequency) ? Integer.compare(x1.num, x2.num) : Integer.compare(x1.frequency, x2.frequency);
            });

            var sum = 0;
            for (var i = 0; i < Math.min(xs.size(), x); i++) {
                final var item = xs.get(xs.size() - i - 1);
                sum += item.num * item.frequency;
            }
            return sum;
        }

        record NumWithFrequency(int num, int frequency) {
        }
    }
}
