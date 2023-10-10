package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/">Minimum Number of Operations to Make Array Continuous (Hard)</a>
 * <p>
 * You are given an integer array nums. In one operation, you can replace any element in nums with any integer.
 * <p>
 * nums is considered continuous if both of the following conditions are fulfilled:
 * <p>
 * All elements in nums are unique.
 * The difference between the maximum element and the minimum element in nums equals nums.length - 1.
 * For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
 * <p>
 * Return the minimum number of operations to make nums continuous.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface MinimumNumberOfOperationsToMakeArrayContinuous {

    int minOperations(int[] nums);

    class MinimumNumberOfOperationsToMakeArrayContinuousRev1 implements MinimumNumberOfOperationsToMakeArrayContinuous {

        @Override
        public int minOperations(int[] nums) {
            int n = nums.length;

            Set<Integer> unique = new HashSet<>();
            for (int x : nums) {
                unique.add(x);
            }

            int m = unique.size();
            List<Integer> xs = new ArrayList<>(unique);
            Collections.sort(xs);

            // sliding window - count numbers that don't need to be replaced
            int left = 0; // points to the smallest element
            int right = 0;
            int noops = 0;
            while (left < m) {
                // try to expand the current window, right boundary is exclusive
                while (right < m && xs.get(right) - xs.get(left) <= n - 1) {
                    right++;
                }
                noops = Math.max(noops, right - left);
                left++;
            }
            return n - noops;
        }
    }

    class MinimumNumberOfOperationsToMakeArrayContinuousRev2 implements MinimumNumberOfOperationsToMakeArrayContinuous {

        @Override
        public int minOperations(int[] nums) {
            int n = nums.length;

            // handle duplicates
            Set<Integer> uniq = new HashSet<>();
            for (int x : nums) {
                uniq.add(x);
            }

            int m = uniq.size();
            nums = new int[m];

            int i = 0;
            for (int x : uniq) {
                nums[i++] = x;
            }

            // sliding window
            Arrays.sort(nums);
            int best = n;

            int left = 0;
            int right = 0;
            while (left < m) {
                // x, ..., x + n - 1, where x = nums[left]
                // ^ min   ^ max
                // expand the current window, right boundary is exclusive
                while (right < m && nums[right] <= nums[left] + n - 1) {
                    right++;
                }

                best = Math.min(best, n - (right - left));
                left++;
            }
            return best;
        }
    }
}
