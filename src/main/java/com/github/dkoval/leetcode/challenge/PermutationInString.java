package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a
 * permutation
 * of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s1.length, s2.length <= 10^4</li>
 *  <li>s1 and s2 consist of lowercase English letters</li>
 * </ul>
 */
public interface PermutationInString {

    boolean checkInclusion(String s1, String s2);

    class PermutationInStringRev2 implements PermutationInString {

        @Override
        public boolean checkInclusion(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();

            if (n2 < n1) {
                return false;
            }

            // idea: sliding window
            int[] counts1 = new int[26];
            int[] counts2 = new int[26];
            for (int i = 0; i < n2; i++) {
                // frequency table of a sliding window of size n1
                counts2[s2.charAt(i) - 'a']++;
                if (i >= n1) {
                    // Example: n1 = 2
                    // 0, 1, 2, 3
                    // ----
                    //    ----
                    //       ----
                    // remove the 1st symbol of the previous window
                    counts2[s2.charAt(i - n1) - 'a']--;
                }

                // frequency table of s1
                if (i < n1) {
                    counts1[s1.charAt(i) - 'a']++;
                }

                if (i >= n1 - 1 && matches(counts1, counts2)) {
                    return true;
                }
            }
            return false;
        }

        private boolean matches(int[] counts1, int[] counts2) {
            for (int i = 0; i < 26; i++) {
                if (counts1[i] != counts2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    class PermutationInStringRev3 implements PermutationInString {

        @Override
        public boolean checkInclusion(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();

            if (n2 < n1) {
                return false;
            }

            // idea: sliding window of size n1
            int[] counts1 = new int[26];
            int[] counts2 = new int[26];
            for (int i = 0; i < n1; i++) {
                counts1[s1.charAt(i) - 'a']++;
                counts2[s2.charAt(i) - 'a']++;
            }

            // index i is the ending index of the current window
            for (int i = n1 - 1; i < n2; i++) {
                if (i > n1 - 1) {
                    // append the current symbol to the current window
                    counts2[s2.charAt(i) - 'a']++;
                    // remove the 1st symbol of the previous window
                    counts2[s2.charAt(i - n1) - 'a']--;
                }

                if (matches(counts1, counts2)) {
                    return true;
                }
            }
            return false;
        }

        private boolean matches(int[] counts1, int[] counts2) {
            for (int i = 0; i < 26; i++) {
                if (counts1[i] != counts2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
