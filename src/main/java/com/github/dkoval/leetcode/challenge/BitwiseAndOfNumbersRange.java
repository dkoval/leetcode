package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/">Bitwise AND of Numbers Range</a>
 * <p>
 * Given two integers left and right that represent the range [left, right],
 * return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * Constraints:
 * <p>
 * 0 <= left <= right <= 2^31 - 1
 */
public interface BitwiseAndOfNumbersRange {

    int rangeBitwiseAnd(int left, int right);

    // Resource: https://www.youtube.com/watch?v=6aHmj9ihjMY
    class BitwiseAndOfNumbersRangeByFindingCommonPrefix implements BitwiseAndOfNumbersRange {

        @Override
        public int rangeBitwiseAnd(int left, int right) {
            // idea: find common prefix in left and right
            int ans = 0;
            // iterate from MSB to LSB
            // 0 <= left <= right <= 2^31 - 1, therefore we can skip 31st bit
            for (int i = 30; i >= 0; i--) {
                int bitInLeft = left & (1 << i);
                int bitInRight = right & (1 << i);
                if (bitInLeft != bitInRight) {
                    // there will be x in [left, right] with (i - 1) .. 0 bits set to 0, therefore bitwise AND will yield 0
                    // x = [prefix] b [00...0]
                    //              ^ i-th bit is a mismatch
                    break;
                }
                ans |= bitInLeft;
            }
            return ans;
        }
    }

    // Resource: https://www.youtube.com/watch?v=VHWd8STTVZs
    class BitwiseAndOfNumbersLarry implements BitwiseAndOfNumbersRange {

        // M = log2(left) - number of bits in `left`
        // N = log2(right) - number of bits in `right`
        // O(max(M, N)) time | O(max(M, N)) space
        @Override
        public int rangeBitwiseAnd(int left, int right) {
            // consider one bit at a time, going from LSB to MSB
            int answer = 0;
            int mask = 1;
            while (left > 0 && right > 0) {
                boolean onlyOnes = onlyOnes(left, right);
                if (onlyOnes) {
                    answer |= mask;
                }
                mask <<= 1;
                left = dropLastBit(left);
                right = dropLastBit(right);
            }
            return answer;
        }

        private boolean onlyOnes(int x, int y) {
            return getLastBit(x) == 1 && getLastBit(y) == 1 // compare last bits of x and y
                    && dropLastBit(x) == dropLastBit(y); // compare "prefixes" of x and y
        }

        private int getLastBit(int x) {
            return x & 1;
        }

        private int dropLastBit(int x) {
            return x >> 1;
        }
    }
}
