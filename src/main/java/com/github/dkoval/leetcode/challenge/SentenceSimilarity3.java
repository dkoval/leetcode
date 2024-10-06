package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/sentence-similarity-iii/">Sentence Similarity III</a>
 * <p>
 * You are given two strings sentence1 and sentence2, each representing a sentence composed of words.
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * Each word consists of only uppercase and lowercase English characters.
 * <p>
 * Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty)
 * inside one of these sentences such that the two sentences become equal.
 * Note that the inserted sentence must be separated from existing words by spaces.
 * <p>
 * Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar.
 * Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li></li>1 <= sentence1.length, sentence2.length <= 100</li>
 *  <li></li>sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.</li>
 *  <li></li>The words in sentence1 and sentence2 are separated by a single space.</li>
 * </ul>
 */
public interface SentenceSimilarity3 {

    boolean areSentencesSimilar(String sentence1, String sentence2);

    class SentenceSimilarity3Rev1 implements SentenceSimilarity3 {

        @Override
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            // Assuming s1 is longer:
            // s1 = {common prefix} + {???} + {common suffix}
            //
            // Insert into:
            // 1. end
            // s1 = a b c d e f g
            //      | | | | ^ ^ ^
            // s2 = a b c d
            //
            // 2. start
            // s1 = a b c d e f g
            //      ^ ^ ^ | | | |
            // s2 =       d e f g
            //
            // 3. middle
            // s1 = a b c d e f g
            //      | ^ ^ ^ ^ | |
            // s2 = a         f g
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            return solve(s1, s2);
        }

        private boolean solve(String[] s1, String[] s2) {
            int n1 = s1.length;
            int n2 = s2.length;

            // let's assume s1 is longer
            if (n1 < n2) {
                return solve(s2, s1);
            }

            // common prefix: s2[0 : l2 - 1] (can be empty)
            int l2 = 0;
            while (l2 < n2 && s1[l2].equals(s2[l2])) {
                l2++;
            }

            // optimization: s2 is a prefix of s1
            if (l2 == n2) {
                return true;
            }


            // common suffix: s2[r2 + 1 : n2 - 1] (can be empty)
            int r1 = n1 - 1;
            int r2 = n2 - 1;
            while (r2 >= 0 && s1[r1].equals(s2[r2])) {
                r1--;
                r2--;
            }

            // Make sure the whole s2 matched.
            // NB. The check also covers the case when s2 is a suffix of s1.
            return l2 > r2;
        }
    }
}
