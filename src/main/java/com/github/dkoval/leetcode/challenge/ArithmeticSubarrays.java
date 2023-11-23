package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/arithmetic-subarrays/">Arithmetic Subarrays</a>
 * <p>
 * A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same.
 * More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
 * <p>
 * For example, these are arithmetic sequences:
 * <pre>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * </pre>
 * The following sequence is not arithmetic:
 * <pre>
 * 1, 1, 2, 5, 7
 * </pre>
 * You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries,
 * where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
 * <p>
 * Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]]
 * can be rearranged to form an arithmetic sequence, and false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>m == l.length</li>
 *  <li>m == r.length</li>
 *  <li>2 <= n <= 500</li>
 *  <li>1 <= m <= 500</li>
 *  <li>0 <= l[i] < r[i] < n</li>
 *  -10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface ArithmeticSubarrays {

    List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r);

    class ArithmeticSubarraysRev1 implements ArithmeticSubarrays {

        @Override
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int m = l.length;

            List<Boolean> ans = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                ans.add(canRearrange(nums, l[i], r[i]));
            }
            return ans;
        }

        private boolean canRearrange(int[] nums, int left, int right) {
            int len = right - left + 1;
            if (len == 1) {
                return false;
            }

            int[] subarr = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(subarr);

            int diff = subarr[1] - subarr[0];
            boolean ans = true;
            for (int i = 2; i < len; i++) {
                if (subarr[i] - subarr[i - 1] != diff) {
                    return false;
                }
            }
            return ans;
        }
    }
}
