package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/reorganize-string/">Reorganize String</a>
 * <p>
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * <p>
 * Return any possible rearrangement of s or return "" if not possible.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 500</li>
 *  <li>s consists of lowercase English letters.</li>
 * </ul>
 */
public interface ReorganizeString {

    String reorganizeString(String s);

    class ReorganizeStringRev1 implements ReorganizeString {

        @Override
        public String reorganizeString(String s) {
            int n = s.length();

            int[] counts = new int[26];
            for (int i = 0; i < n; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            // sort characters by frequency in DESC order
            Queue<CharInfo> maxHeap = new PriorityQueue<>(Comparator.comparingInt(it -> -it.count));
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    maxHeap.offer(new CharInfo((char)('a' + i), counts[i]));
                }
            }

            // alternate placing the most common letters
            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                CharInfo firstBiggest = maxHeap.poll();
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == firstBiggest.c) {
                    // can't use the 1st biggest character
                    if (maxHeap.isEmpty()) {
                        return "";
                    }

                    // try the 2nd biggest character
                    CharInfo secondBiggest = maxHeap.poll();
                    sb.append(secondBiggest.c);
                    secondBiggest.count--;
                    if (secondBiggest.count > 0) {
                        maxHeap.offer(secondBiggest);
                    }
                } else {
                    // can use the first biggest character
                    sb.append(firstBiggest.c);
                    firstBiggest.count--;
                }

                // in both cases return the 1st biggest character to the max heap
                if (firstBiggest.count > 0) {
                    maxHeap.offer(firstBiggest);
                }
            }
            return sb.toString();
        }

        private static class CharInfo {
            final char c;
            int count;

            CharInfo(char c, int count) {
                this.c = c;
                this.count = count;
            }

            public String toString() {
                return String.format("(letter = %c, count = %d)", c, count);
            }
        }
    }
}
