package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/">Minimum Limit of Balls in a Bag</a>
 * <p>
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
 * <p>
 * You can perform the following operation at most maxOperations times:
 * <p>
 * Take any bag of balls and divide it into two new bags with a positive number of balls.
 * For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
 * <p>
 * Return the minimum possible penalty after performing the operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= maxOperations, nums[i] <= 10^9</li>
 * </ul>
 */
public interface MinimumLimitOfBallsInBag {

    int minimumSize(int[] nums, int maxOperations);

    class MinimumLimitOfBallsInBagUsingBinarySearchRev1 implements MinimumLimitOfBallsInBag {

        // O(N * logR) time, where R = max(nums) = 10^9 | O(1) space
        @Override
        public int minimumSize(int[] nums, int maxOperations) {
            // Given the maximum number of balls in a bag (i.e. your penalty) is K, can we achieve this in at most maxOperations?
            // f(K)
            // Note that f(K) >= f(K + 1)
            // Condition f(K) <= maxOperations evaluates to true at some point:
            // FF...FTT...T
            //       ^ answer
            // We can find the minimum such K using binary search.
            int left = 1;
            int right = max(nums);
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isGood(nums, mid, maxOperations)) {
                    // mid is a possible solution;
                    // check if there is better option to the left of mid
                    right = mid;
                } else {
                    // mid is not a solution
                    left = mid + 1;
                }
            }
            return left;
        }

        private int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int x : nums) {
                max = Math.max(max, x);
            }
            return max;
        }

        // O(N) time | O(1) space
        private boolean isGood(int[] nums, int maxBallsInBag, int maxOperations) {
            // How many new bags of size maxBallsInBag can we make?
            int count = 0;
            for (int x : nums) {
                // 9 / 3 = 3: [9] -> [6, 3] -> [3, 3, 3], 2 new bags created
                // 7 / 3 = 2: [7] -> [1, 6] -> [1, 3, 3], 2 new bags created
                // div_round_up(x / y) = (x + y - 1) / y = (x - 1) / y + 1
                // the number of new bags created = div_round_up(x, maxBallsInBag) - 1
                count += (x - 1) / maxBallsInBag;
            }
            return count <= maxOperations;
        }
    }
}
