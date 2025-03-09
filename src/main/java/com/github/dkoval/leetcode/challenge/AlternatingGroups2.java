package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/alternating-groups-ii/">Alternating Groups II</a>
 * <p>
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k.
 * The color of tile i is represented by colors[i]:
 * <ul>
 *  <li>colors[i] == 0 means that tile i is red.</li>
 *  <li>colors[i] == 1 means that tile i is blue.</li>
 * </ul>
 * An alternating group is every k contiguous tiles in the circle with alternating colors
 * (each tile in the group except the first and last one has a different color from its left and right tiles).
 * <p>
 * Return the number of alternating groups.
 * <p>
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= colors.length <= 10^5</li>
 *  <li>0 <= colors[i] <= 1</li>
 *  <li>3 <= k <= colors.length</li>
 * </ul>
 */
public interface AlternatingGroups2 {

    int numberOfAlternatingGroups(int[] colors, int k);

    class AlternatingGroups2Rev1 implements AlternatingGroups2 {

        @Override
        public int numberOfAlternatingGroups(int[] colors, int k) {
            final var n = colors.length;

            // Idea: sliding window.
            // Trivia fact: if the starting index of a group is (n - 1) we want to
            // take (k - 1) firsts elements for the group to be of size k.
            var count = 0;
            var left = 0;
            for (var right = 1; right < n + k - 1; right++) {
                if (colors[right % n] == colors[(right - 1) % n]) {
                    // elements aren't alternating, hence reset the window
                    left = right;
                }

                // is window too big?
                if (right - left + 1 > k) {
                    left++;
                }

                if (right - left + 1 == k) {
                    count++;
                }
            }
            return count;
        }
    }

    class AlternatingGroups2Rev2 implements AlternatingGroups2 {

        @Override
        public int numberOfAlternatingGroups(int[] colors, int k) {
            final var n = colors.length;

            // If the starting index is (n - 1) we want to
            // take (k - 1) firsts elements to form a group of size k.
            var count = 0;
            var streak = 1;
            for (var right = 1; right < n + k - 1; right++) {
                if (colors[right % n] != colors[(right - 1) % n]) {
                    streak++;
                } else {
                    // elements aren't alternating, hence reset the steak
                    streak = 1;
                }

                if (streak >= k) {
                    count++;
                }
            }
            return count;
        }
    }
}
