package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/largest-substring-between-two-equal-characters/">Largest Substring Between Two Equal Characters</a>
 * <p>
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters.
 * If there is no such substring return -1.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 300</li>
 *  <li>s contains only lowercase English letters</li>
 * </ul>
 */
public interface LargestSubstringBetweenTwoEqualCharacters {

    int maxLengthBetweenEqualCharacters(String s);

    class LargestSubstringBetweenTwoEqualCharactersRev1 implements LargestSubstringBetweenTwoEqualCharacters {

        @Override
        public int maxLengthBetweenEqualCharacters(String s) {
            int n = s.length();

            int best = -1;
            Map<Character, Integer> seen = new HashMap<>();
            for (int end = 0; end < n; end++) {
                char c = s.charAt(end);
                if (!seen.containsKey(c)) {
                    seen.put(c, end);
                } else {
                    int start = seen.get(c);
                    best = Math.max(best, end - start - 1);
                }
            }
            return best;
        }
    }
}
