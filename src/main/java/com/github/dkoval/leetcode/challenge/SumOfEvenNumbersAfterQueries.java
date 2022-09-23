package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sum-of-even-numbers-after-queries/">Sum of Even Numbers After Queries</a>
 * <p>
 * You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
 * <p>
 * For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.
 * <p>
 * Return an integer array answer where answer[i] is the answer to the ith query.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^4</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 *  <li>1 <= queries.length <= 10^4</li>
 *  <li>-10^4 <= vali <= 10^4</li>
 *  <li>0 <= indexi < nums.length</li>
 * </ul>
 */
public interface SumOfEvenNumbersAfterQueries {

    int[] sumEvenAfterQueries(int[] nums, int[][] queries);

    class SumOfEvenNumbersAfterQueriesRev1 implements SumOfEvenNumbersAfterQueries {

        @Override
        public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
            int evenSum = 0;
            for (int x : nums) {
                evenSum += (x % 2 == 0) ? x : 0;
            }

            List<Integer> ans = new ArrayList<>();
            for (int[] query : queries) {
                int val = query[0];
                int idx = query[1];

                int prev = nums[idx];
                nums[idx] += val;

                if (prev % 2 == 0) {
                    if (nums[idx] % 2 == 0) {
                        evenSum += val;
                    } else {
                        evenSum -= prev;
                    }
                } else {
                    if (nums[idx] % 2 == 0) {
                        evenSum += nums[idx];
                    }
                    // both prev and nums[idx] are odd, nothing to do otherwise
                }

                ans.add(evenSum);
            }

            int n = ans.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
    }
}
