package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface LargestDivisibleSubset {

    List<Integer> largestDivisibleSubset(int[] nums);

    // Resource: https://www.youtube.com/watch?v=oYLSnqjN_Zs
    class LargestDivisibleSubsetDPBottomUpWithPathReconstruction implements LargestDivisibleSubset {

        // O(N^2) time | O(N) space
        @Override
        public List<Integer> largestDivisibleSubset(int[] nums) {
            // The problem is similar to "Finding the longest path in a DAG", which can be solved with DP
            int n = nums.length;
            Arrays.sort(nums);

            // dp[i] = k denotes that nums[i] is divisible by previous k numbers < nums[i] (because nums[] is sorted in asc order)
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            // parent[i] = j (came to index i from some previous index j) denotes that nums[j] is the "parent" of nums[i],
            // i.e. nums[i] is a multiple of nums[j]: nums[i] = k * nums[j] <=> nums[i] % nums[j] == 0
            int[] parent = new int[n];
            Arrays.fill(parent, -1);

            // stores index of the max element in dp[]
            int bestIdx = 0;
            for (int i = 0; i < n; i++) {
                // nums[j] is the "parent" of nums[i] if nums[i] is a multiple of nums[j], i.e.
                // nums[i] = k * nums[j] <=> nums[i] % nums[j] == 0
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            parent[i] = j;

                            // keep track of the max element in dp[]
                            if (dp[i] > dp[bestIdx]) {
                                bestIdx = i;
                            }
                        }
                    }
                }
            }

            // reconstruct the longest path from parent[]
            List<Integer> ans = new ArrayList<>();
            int i = bestIdx;
            while (i != -1) {
                ans.add(nums[i]);
                i = parent[i];
            }

            Collections.reverse(ans);
            return ans;
        }
    }
}
