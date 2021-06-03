package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3766/">Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts</a>
 * <p>
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts
 * where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
 * verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 * <p>
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in
 * the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.
 */
public class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {

    private static final long MOD = 1_000_000_007;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHeight = maxPieceLength(horizontalCuts, h);
        int maxWidth = maxPieceLength(verticalCuts, w);
        long maxArea = maxHeight % MOD * maxWidth % MOD;
        return (int) (maxArea % MOD);
    }

    private int maxPieceLength(int[] cuts, int d) {
        // calc consecutive differences between elements of cuts[] and take the maximum one
        int n = cuts.length;
        // compare 1st and last pieces
        int maxLength = Math.max(cuts[0], d - cuts[n - 1]);
        for (int i = 1; i < n; i++) {
            maxLength = Math.max(maxLength, cuts[i] - cuts[i - 1]);
        }
        return maxLength;
    }
}
