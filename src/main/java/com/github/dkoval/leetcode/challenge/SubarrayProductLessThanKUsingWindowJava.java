package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.problems.SubarrayProductLessThanK;
import org.jetbrains.annotations.NotNull;

public class SubarrayProductLessThanKUsingWindowJava implements SubarrayProductLessThanK {

    // O(N) time | O(1) space
    @Override
    public int numSubarrayProductLessThanK(@NotNull int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        // sliding window
        int count = 0;
        int l = 0;
        int product = 1;
        for (int r = 0; r < nums.length; r++) {
            if (nums[l] >= k) {
                l = r + 1;
                product = 1;
                continue;
            }

            product *= nums[r];
            while (product >= k) {
                product /= nums[l];
                l++;
            }

            // increase the total count by the number of subarrays ending at index r
            // [..., nums[l], nums[l + 1] , ..., nums[r - 1], nums[r], ...]
            //                                                <----->
            //                                   <------------------>
            //                <------------------------------------->
            //       <---------------------------------------------->
            count += r - l + 1;
        }
        return count;
    }
}
