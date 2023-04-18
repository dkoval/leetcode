package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/">Merge Strings Alternately</a>
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word1.length, word2.length <= 100</li>
 *  <li>word1 and word2 consist of lowercase English letters.</li>
 * </ul>
 */
public interface MergeStringsAlternately {

    String mergeAlternately(String word1, String word2);

    // O(max(N1, N2)) time | O(N1 + N2) space
    class MergeStringsAlternatelyRev1 implements MergeStringsAlternately {

        @Override
        public String mergeAlternately(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.max(n1, n2); i++) {
                if (i < n1) {
                    sb.append(word1.charAt(i));
                }

                if (i < n2) {
                    sb.append(word2.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    // O(max(N1, N2)) time | O(N1 + N2) space
    class MergeStringsAlternatelyRev2 implements MergeStringsAlternately {

        @Override
        public String mergeAlternately(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();

            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < Math.min(n1, n2)) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
                i++;
            }

            while (i < n1) {
                sb.append(word1.charAt(i));
                i++;
            }

            while (i < n2) {
                sb.append(word2.charAt(i));
                i++;
            }
            return sb.toString();
        }
    }
}
