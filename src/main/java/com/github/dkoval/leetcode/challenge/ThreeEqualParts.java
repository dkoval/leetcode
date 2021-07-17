package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3817/">Three Equal Parts</a>
 *
 * You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts
 * such that all of these parts represent the same binary value.
 * <p>
 * If it is possible, return any [i, j] with i + 1 < j, such that:
 * <ul>
 *  <li>arr[0], arr[1], ..., arr[i] is the first part,</li>
 *  <li>arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and</li>
 *  <li>arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.</li>
 *  <li>All three parts have equal binary values.</li>
 * </ul>
 * If it is not possible, return [-1, -1].
 * <p>
 * Note that the entire part is used when considering what binary value it represents.
 * For example, [1,1,0] represents 6 in decimal, not 3.
 * Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= arr.length <= 3 * 10^4</li>
 *  <li>arr[i] is 0 or 1</li>
 * </ul>
 */
public class ThreeEqualParts {

    // O(N) time | O(1) space
    // Resource: https://achievementguru.com/leetcode-927-three-equal-parts-java-solution/
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;

        int countOnes = 0;
        for (int x : arr) {
            // x is either 0 or 1
            countOnes += x;
        }

        if (countOnes % 3 != 0) {
            return new int[]{-1, -1};
        }

        if (countOnes == 0) {
            return new int[]{0, n - 1};
        }

        int onesPerPart = countOnes / 3;
        int start = -1, mid = -1, end = -1;
        countOnes = 0;

        // mark the very first 1s in all three parts, ignoring 0s along the way
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                continue;
            }

            countOnes++;
            if (countOnes == 1) {
                start = i;
            } else if (countOnes == onesPerPart + 1) {
                mid = i;
            } else if (countOnes == 2 * onesPerPart + 1) {
                end = i;
                break;
            }
        }

        // validate three binary values represented by arr[start:mid-1], arr[mid:end-1], arr[end:]
        while (end < n && arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start++;
            mid++;
            end++;
        }

        if (end == n) {
            return new int[]{start - 1, mid};
        }
        return new int[]{-1, -1};
    }
}
