package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/">Shortest Distance to Target String in a Circular Array</a>
 * <p>
 * You are given a 0-indexed circular string array words and a string target.
 * A circular array means that the array's end connects to the array's beginning.
 * <p>
 * Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n],
 * where n is the length of words.
 * Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.
 * <p>
 * Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 100</li>
 *  <li>words[i] and target consist of only lowercase English letters.</li>
 *  <li>0 <= startIndex < words.length</li>
 * </ul>
 */
public interface ShortestDistanceToTargetStringInCircularArray {

    int closestTarget(String[] words, String target, int startIndex);

    class ShortestDistanceToTargetStringInCircularArrayRev1 implements ShortestDistanceToTargetStringInCircularArray {

        @Override
        public int closestTarget(String[] words, String target, int startIndex) {
            var best = Integer.MAX_VALUE;
            best = Math.min(best, move(words, startIndex, target, 1));
            best = Math.min(best, move(words, startIndex, target, -1));
            return (best == Integer.MAX_VALUE) ? -1 : best;
        }

        private int move(String[] words, int startIndex, String target, int increment) {
            final var n = words.length;

            if (words[startIndex].equals(target)) {
                return 0;
            }

            var moves = 0;
            var found = false;
            var i = mod(startIndex + increment, n);
            while (i != startIndex) {
                moves++;
                if (words[i].equals(target)) {
                    found = true;
                    break;
                }
                i = mod(i + increment, n);
            }
            return found ? moves : Integer.MAX_VALUE;
        }

        private int mod(int x, int n) {
            x %= n;
            return (x < 0) ? x + n : x;
        }
    }

    class ShortestDistanceToTargetStringInCircularArrayRev2 implements ShortestDistanceToTargetStringInCircularArray {

        @Override
        public int closestTarget(String[] words, String target, int startIndex) {
            final var n = words.length;

            var best = Integer.MAX_VALUE;
            for (var i = 0; i < n; i++) {
                if (words[i].equals(target)) {
                    best = Math.min(best, Math.min(Math.abs(i - startIndex), n - Math.abs(i - startIndex)));
                }
            }
            return (best == Integer.MAX_VALUE) ? -1 : best;
        }
    }
}
