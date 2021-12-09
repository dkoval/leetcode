package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/jump-game-iii/">Jump Game III</a>
 * <p>
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 5 * 10^4</li>
 *  <li>0 <= arr[i] < arr.length</li>
 *  <li>0 <= start < arr.length</li>
 * </ul>
 */
public interface JumpGame3 {

    boolean canReach(int[] arr, int start);

    // O(N) time | O(N) space
    class JumpGame3DPTopDown implements JumpGame3 {

        public boolean canReach(int[] arr, int start) {
            Boolean[] memo = new Boolean[arr.length];
            return canReach(arr, start, memo);
        }

        private boolean canReach(int[] arr, int idx, Boolean[] memo) {
            if (idx < 0 || idx >= arr.length) {
                return false;
            }

            if (arr[idx] < 0) {
                return false;
            }

            if (arr[idx] == 0) {
                return true;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            // mark the current index as visited to avoid going in cycles
            int numSteps = arr[idx];
            arr[idx] = -1;

            // check if we can reach to any index with value 0 by jumping arr[i] steps in both directions
            memo[idx] = canReach(arr, idx + numSteps, memo) || canReach(arr, idx - numSteps, memo);

            arr[idx] = numSteps;
            return memo[idx];
        }
    }
}
