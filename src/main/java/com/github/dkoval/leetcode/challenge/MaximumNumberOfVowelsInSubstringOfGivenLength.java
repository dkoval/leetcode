package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">Maximum Number of Vowels in a Substring of Given Length</a>
 * <p>
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters</li>
 *  <li>1 <= k <= s.length</li>
 * </ul>
 */
public interface MaximumNumberOfVowelsInSubstringOfGivenLength {

    int maxVowels(String s, int k);

    class MaximumNumberOfVowelsInSubstringOfGivenLengthRev1 implements MaximumNumberOfVowelsInSubstringOfGivenLength {
        private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        @Override
        public int maxVowels(String s, int k) {
            int n = s.length();

            // sliding window of length k
            int best = 0;
            int count = 0;
            for (int end = 0; end < n; end++) {
                char c = s.charAt(end);
                if (VOWELS.contains(c)) {
                    count++;
                }

                if (end >= k) {
                    // remove the starting character of the previous window
                    char x = s.charAt(end - k);
                    if (VOWELS.contains(x)) {
                        count--;
                    }
                }
                best = Math.max(best, count);
            }
            return best;
        }
    }
}
