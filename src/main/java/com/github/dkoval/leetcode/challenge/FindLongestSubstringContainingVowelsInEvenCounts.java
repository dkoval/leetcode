package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/">Find the Longest Substring Containing Vowels in Even Counts</a>
 * <p>
 * Given the string s, return the size of the longest substring containing each vowel an even number of times.
 * That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 5 x 10^5</li>
 *  <li>s contains only lowercase English letters</li>
 * </ul>
 */
public interface FindLongestSubstringContainingVowelsInEvenCounts {

    int findTheLongestSubstring(String s);

    class FindLongestSubstringContainingVowelsInEvenCountsRev1 implements FindLongestSubstringContainingVowelsInEvenCounts {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

        @Override
        public int findTheLongestSubstring(String s) {
            int n = s.length();

            // State: for every index, record how many times each vowel a, e, i, o and u occurs.
            // We don't need to know the precise counts though as we're only interested whether
            // the number of occurrences of a particular vowel is odd or even.
            // 0 - even, 1 - odd. There are 5 vowels in total, therefore the state can be represented as a bitmask.

            // state -> index
            Map<Integer, Integer> seen = new HashMap<>();
            seen.put(0, -1);

            int state = 0;
            int length = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);

                if (VOWELS.contains(c)) {
                    // flip the vowel's bit
                    state ^= 1 << (c - 'a');
                }

                if (seen.containsKey(state)) {
                    // the number of vowels between the current and an already seen state is guaranteed to be even
                    length = Math.max(length, i - seen.get(state));
                } else {
                    seen.put(state, i);
                }
            }
            return length;
        }
    }
}
