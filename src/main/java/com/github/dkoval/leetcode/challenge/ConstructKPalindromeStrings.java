package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/construct-k-palindrome-strings/">Construct K Palindrome Strings</a>
 * <p>
 * Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of lowercase English letters.</li>
 *  <li>1 <= k <= 10^5</li>
 * </ul>
 */
public interface ConstructKPalindromeStrings {

    boolean canConstruct(String s, int k);

    class ConstructKPalindromeStringsRev1 implements ConstructKPalindromeStrings {

        @Override
        public boolean canConstruct(String s, int k) {
            final var n = s.length();

            if (n < k) {
                return false;
            }

            final var counts = new int[26];
            for (var i = 0; i < n; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            // NB. A valid palindrome string can have at most 1 character with odd count:
            // s1 = prefix | x | reverse(prefix) <- valid
            // s2 = prefix | x x x | reverse(prefix) <- valid
            var odds = 0;
            for (var count : counts) {
                if (count % 2 != 0) {
                    odds++;
                }
            }
            return odds <= k;
        }
    }
}
