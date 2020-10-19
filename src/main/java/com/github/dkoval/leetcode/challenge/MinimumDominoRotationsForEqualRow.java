package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/">Minimum Domino Rotations For Equal Row</a>
 * <p>
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the ith domino, so that A[i] and B[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 * <p>
 * If it cannot be done, return -1.
 */
public abstract class MinimumDominoRotationsForEqualRow {

    public abstract int minDominoRotations(int[] A, int[] B);

    public static class MinimumDominoRotationsForEqualRowGreedyWithFourCheck extends MinimumDominoRotationsForEqualRow {

        @Override
        public int minDominoRotations(int[] A, int[] B) {
            int answer = Math.min(numSwaps(A[0], A, B), numSwaps(B[0], A, B));
            answer = Math.min(answer, numSwaps(A[0], B, A));
            answer = Math.min(answer, numSwaps(B[0], B, A));
            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        // returns min number of swaps needed to make all elements of A[] equal to target
        private int numSwaps(int target, int[] A, int[] B) {
            int numSwaps = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != target && B[i] != target) {
                    return Integer.MAX_VALUE;
                } else if (A[i] != target) {
                    numSwaps++;
                }
            }
            return numSwaps;
        }
    }

    public static class MinimumDominoRotationsForEqualRowSinglePass extends MinimumDominoRotationsForEqualRow {

        @Override
        public int minDominoRotations(int[] A, int[] B) {
            return 0;
        }
    }
}
