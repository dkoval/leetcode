package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a>
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface LongestConsecutiveSequence {

    int longestConsecutive(int[] nums);

    // O(N) time | O(N) space
    class LongestConsecutiveSequenceRev1 implements LongestConsecutiveSequence {

        @Override
        public int longestConsecutive(int[] nums) {
            Set<Integer> uniq = new HashSet<>();
            for (int x : nums) {
                uniq.add(x);
            }

            // idea: try every number x in `uniq` and see how further a consecutive sequence starting at x can be extended
            int maxLength = 0;
            for (int x : uniq) {
                if (!uniq.contains(x - 1)) {
                    // star a new consecutive sequence from x: [x, x + 1, x + 2, ...]
                    int length = 1;
                    int y = x + 1;
                    while (uniq.contains(y)) {
                        length++;
                        y++;
                    }
                    maxLength = Math.max(maxLength, length);
                }
            }
            return maxLength;
        }
    }

    // O(N*logN) time | O(1) space
    class LongestConsecutiveSequenceRev2 implements LongestConsecutiveSequence {

        @Override
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int maxLength = 1;
            int length = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    // the current sequence is neither extended nor broken, so we simply move on to the next number
                    continue;
                }

                if (nums[i] == nums[i - 1] + 1) {
                    // nums[i] extends the current sequence
                    length++;
                } else {
                    // at this stage, the current sequence is broken, therefore start a new sequence from nums[i]
                    length = 1;
                }
                maxLength = Math.max(maxLength, length);
            }
            return maxLength;
        }
    }
}
