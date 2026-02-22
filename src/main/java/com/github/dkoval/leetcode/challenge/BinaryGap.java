package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/binary-gap/">Binary Gap</a>
 * <p>
 * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n.
 * If there are no two adjacent 1's, return 0.
 * <p>
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
 * The distance between two 1's is the absolute difference between their bit positions.
 * For example, the two 1's in "1001" have a distance of 3.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^9
 */
public interface BinaryGap {

    int binaryGap(int n);

    class BinaryGapRev1 implements BinaryGap {

        @Override
        public int binaryGap(int n) {
            final var positions = new ArrayList<Integer>();
            for (var i = 0; i < 32; i++) {
                if (((n >> i) & 1) == 1) {
                    positions.add(i);
                }
            }

            var best = 0;
            for (var i = 0; i < positions.size() - 1; i++) {
                best = Math.max(best, positions.get(i + 1) - positions.get(i));
            }
            return best;
        }
    }

    class BinaryGapRev2 implements BinaryGap {

        @Override
        public int binaryGap(int n) {
            var best = 0;
            var prevPos = -1;
            for (var i = 0; i < 32; i++) {
                if (((n >> i) & 1) == 1) {
                    if (prevPos >= 0) {
                        best = Math.max(best, i - prevPos);
                    }
                    prevPos = i;
                }
            }
            return best;
        }
    }
}
