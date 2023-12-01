package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">Check If Two String Arrays are Equivalent</a>
 * <p>
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 * <p>
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word1.length, word2.length <= 10^3</li>
 *  <li>1 <= word1[i].length, word2[i].length <= 10^3</li>
 *  <li>1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3</li>
 *  <li>word1[i] and word2[i] consist of lowercase letters.</li>
 */
public interface CheckIfTwoStringArraysAreEquivalent {

    boolean arrayStringsAreEqual(String[] word1, String[] word2);

    class CheckIfTwoStringArraysAreEquivalentRev1 implements CheckIfTwoStringArraysAreEquivalent {

        @Override
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder s1 = new StringBuilder();
            for (String w1 : word1) {
                s1.append(w1);
            }

            StringBuilder s2 = new StringBuilder();
            for (String w2 : word2) {
                s2.append(w2);
            }

            return s1.toString().equals(s2.toString());
        }
    }

    class CheckIfTwoStringArraysAreEquivalentRev2 implements CheckIfTwoStringArraysAreEquivalent {

        @Override
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder sb1 = concat(word1);
            StringBuilder sb2 = concat(word2);
            return equals(sb1, sb2);
        }

        private StringBuilder concat(String[] word) {
            StringBuilder sb = new StringBuilder();
            for (String chars : word) {
                sb.append(chars);
            }
            return sb;
        }

        private boolean equals(StringBuilder sb1, StringBuilder sb2) {
            if (sb1 == sb2) {
                return true;
            }
            if (sb1 == null || sb2 == null) {
                return false;
            }
            if (sb1.length() != sb2.length()) {
                return false;
            }
            for (int i = 0; i < sb1.length(); i++) {
                if (sb1.charAt(i) != sb2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    class CheckIfTwoStringArraysAreEquivalentRev3 implements CheckIfTwoStringArraysAreEquivalent {

        @Override
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int n1 = word1.length;
            int n2 = word2.length;

            int index1 = 0;
            int offset1 = 0;
            int index2 = 0;
            int offset2 = 0;
            while (index1 < n1 && index2 < n2) {
                if (word1[index1].charAt(offset1) != word2[index2].charAt(offset2)) {
                    return false;
                }

                offset1++;
                if (offset1 == word1[index1].length()) {
                    index1++;
                    offset1 = 0;
                }

                offset2++;
                if (offset2 == word2[index2].length()) {
                    index2++;
                    offset2 = 0;
                }
            }
            return (index1 == n1) && (index2 == n2);
        }
    }
}
