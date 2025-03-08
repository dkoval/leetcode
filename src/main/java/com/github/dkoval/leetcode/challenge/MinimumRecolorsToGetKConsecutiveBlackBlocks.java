package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">Minimum Recoloring to Get a Consecutive Black Blocks</a>
 * <p>
 * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block.
 * The characters 'W' and 'B' denote the colors white and black, respectively.
 * <p>
 * You are also given an integer k, which is the desired number of consecutive black blocks.
 * <p>
 * In one operation, you can recolor a white block such that it becomes a black block.
 * <p>
 * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == blocks.length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>blocks[i] is either 'W' or 'B'.</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface MinimumRecolorsToGetKConsecutiveBlackBlocks {

    int minimumRecolors(String blocks, int k);

    class MinimumRecolorsToGetKConsecutiveBlackBlocksRev1 implements MinimumRecolorsToGetKConsecutiveBlackBlocks {

        @Override
        public int minimumRecolors(String blocks, int k) {
            final var n = blocks.length();

            // sliding window
            var whites = 0;
            var best = n;
            for (var i = 0; i < n; i++) {
                whites += (blocks.charAt(i) == 'W') ? 1 : 0;
                if (i < k - 1) {
                    continue;
                }

                // remove the 1st elements of the previous window
                if (i >= k) {
                    whites -= (blocks.charAt(i - k) == 'W') ? 1 : 0;
                }

                // minimize the number of recolors, i.e. W -> B
                best = Math.min(best, whites);
                if (best == 0) {
                    break;
                }
            }
            return best;
        }
    }
}
