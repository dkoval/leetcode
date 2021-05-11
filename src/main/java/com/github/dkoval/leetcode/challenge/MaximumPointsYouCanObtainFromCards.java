package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3739/">Maximum Points You Can Obtain from Cards</a>
 * <p>
 * There are several cards arranged in a row, and each card has an associated number of points.
 * The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= cardPoints.length <= 10^5</li>
 *  <li>1 <= cardPoints[i] <= 10^4</li>
 *  <li>1 <= k <= cardPoints.length</li>
 * </ul>
 */
public class MaximumPointsYouCanObtainFromCards {

    // O(N) time | O(1) space
    public int maxScore(int[] cardPoints, int k) {
        // Keep a window of size m = n - k over the array. The answer is max(answer, sumOfArray - sumOfCurrentWindow)
        int totalSum = 0;
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
        }

        int score = 0;
        int windowSum = 0;
        int n = cardPoints.length, m = n - k;
        // consider all windows of size m = n - k
        for (int i = 0; i < n; i++) {
            if (i >= m) {
                score = Math.max(score, totalSum - windowSum);
                windowSum -= cardPoints[i - m]; // keep sum of last m elements
            }
            windowSum += cardPoints[i];
        }
        return Math.max(score, totalSum - windowSum);
    }
}
