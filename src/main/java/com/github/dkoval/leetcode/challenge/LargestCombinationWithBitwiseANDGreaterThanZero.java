package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/">Largest Combination With Bitwise AND Greater Than Zero</a>
 * <p>
 * The bitwise AND of an array nums is the bitwise AND of all integers in nums.
 * <p>
 * For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1. Also, for nums = [7], the bitwise AND is 7.
 * <p>
 * You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates.
 * Each number in candidates may only be used once in each combination.
 * <p>
 * Return the size of the largest combination of candidates with a bitwise AND greater than 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= candidates.length <= 10^5</li>
 *  <li>1 <= candidates[i] <= 10^7</li>
 * </ul>
 */
public interface LargestCombinationWithBitwiseANDGreaterThanZero {

    int largestCombination(int[] candidates);

    class LargestCombinationWithBitwiseANDGreaterThanZeroRev1 implements LargestCombinationWithBitwiseANDGreaterThanZero {

        @Override
        public int largestCombination(int[] candidates) {
            // For the bitwise AND to be > 0, at least one bit should be 1
            // for every number in the combination.
            int bestLength = 0;
            // For every bit position, calculate the size of the largest combination
            // such that bitwise AND will have 1 in that position.
            for (int i = 0; i < 32; i++) {
                int currLength = 0;
                for (int x : candidates) {
                    if (((x >> i) & 1) == 1) {
                        // include x into a combination
                        currLength++;
                    }
                }
                bestLength = Math.max(bestLength, currLength);
            }
            return bestLength;
        }
    }

    class LargestCombinationWithBitwiseANDGreaterThanZeroRev2 implements LargestCombinationWithBitwiseANDGreaterThanZero {

        @Override
        public int largestCombination(int[] candidates) {
            // bits[i] - among all the candidates, how many set bits are there in the i-th bit position?
            int[] bits = new int[32];
            for (int x : candidates) {
                // consider every bit position
                for (int i = 0; i < 32; i++) {
                    if (((x >> i) & 1) == 1) {
                        bits[i]++;
                    }
                }
            }

            int best = 0;
            for (int b : bits) {
                best = Math.max(best, b);
            }
            return best;
        }
    }
}
