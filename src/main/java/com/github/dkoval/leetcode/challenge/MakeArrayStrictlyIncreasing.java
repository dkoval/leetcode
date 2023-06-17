package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/make-array-strictly-increasing/">Make Array Strictly Increasing (Hard)</a>
 * <p>
 * Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.
 * <p>
 * In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].
 * <p>
 * If there is no way to make arr1 strictly increasing, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr1.length, arr2.length <= 2000</li>
 *  <li>0 <= arr1[i], arr2[i] <= 10^9</li>
 * </ul>
 */
public interface MakeArrayStrictlyIncreasing {

    int makeArrayIncreasing(int[] arr1, int[] arr2);

    class MakeArrayStrictlyIncreasingRev1 implements MakeArrayStrictlyIncreasing {

        @Override
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            // Idea: DP top-down + greedy + binary search to find the index j of smallest number arr2[j] > target
            Arrays.sort(arr2);

            // Changing parameters of minOps() recursive function are index i and array arr1.
            // Inside minOps() we compare current arr[i] with previous arr[i - 1],
            // therefore the cache key could be defined as a tuple (i, arr[i - 1]).
            int ans = minOps(arr1, arr2, 0, new HashMap<>());
            return (ans != Integer.MAX_VALUE) ? ans : -1;
        }

        private int minOps(int[] arr1, int[] arr2, int i, Map<List<Integer>, Integer> dp) {
            int n1 = arr1.length;
            int n2 = arr2.length;

            if (i >= n1) {
                return 0;
            }

            // already solved?
            // 0 <= arr1[i], arr2[i] <= 10^9
            List<Integer> key = Arrays.asList(i, i > 0 ? arr1[i - 1] : -1);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            // Scenario #1. Bad: arr1[i] <= arr1[i - 1]
            // Option #1.1. Replace arr1[i] with the smallest arr2[j] > arr[i - 1] to make arr1[0 : i] increasing.

            // Scenario #2. Good: arr[i] > arr[i - 1]
            // Option #2.1. Nothing to do, proceed to index (i + 1).
            // Option #2.2. Replace arr1[i] with the smallest arr2[j] > arr[i - 1] to minimize the number of operations that might be needed later on (greedy).

            int best = Integer.MAX_VALUE;

            // handle scenarios #1.1 and #2.2
            // corner case: i = 0, replace arr1[0] with arr2[0], i.e. the smallest number in arr2
            int j = (i > 0) ? ceil(arr2, arr1[i - 1]) : 0;
            if (j < n2) {
                int tmp = arr1[i];
                arr1[i] = arr2[j];
                int ans = minOps(arr1, arr2, i + 1, dp);
                arr1[i] = tmp; // backtrack
                if (ans != Integer.MAX_VALUE) {
                    best = Math.min(best, 1 + ans);
                }
            }

            // handle scenario #2.1
            if (i == 0 || arr1[i] > arr1[i - 1]) {
                int ans = minOps(arr1, arr2, i + 1, dp);
                if (ans != Integer.MAX_VALUE) {
                    best = Math.min(best, ans);
                }
            }

            // cache and return the answer
            dp.put(key, best);
            return best;
        }

        private int ceil(int[] arr, int target) {
            // binary search
            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > target) {
                    // mid might be the answer;
                    // check if there's a better option to the left of index mid
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
