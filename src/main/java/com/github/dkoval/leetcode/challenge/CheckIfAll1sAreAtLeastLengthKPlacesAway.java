package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/">Check If All 1's Are at Least Length K Places Away</a>
 * <p>
 * Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= k <= nums.length</li>
 *  <li>nums[i] is 0 or 1</li>
 * </ul>
 */
public interface CheckIfAll1sAreAtLeastLengthKPlacesAway {

    boolean kLengthApart(int[] nums, int k);

    class CheckIfAll1sAreAtLeastLengthKPlacesAwayRev1 implements CheckIfAll1sAreAtLeastLengthKPlacesAway {

        @Override
        public boolean kLengthApart(int[] nums, int k) {
            final var n = nums.length;

            var lastIndex = -1;
            for (var i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    continue;
                }

                if (lastIndex >= 0 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
            return true;
        }
    }
}
