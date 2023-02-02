package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/description/">Verifying an Alien Dictionary</a>
 * <p>
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographically in this alien language.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 20</li>
 *  <li>order.length == 26</li>
 *  <li>All characters in words[i] and order are English lowercase letters.</li>
 * </ul>
 */
public interface VerifyingAlienDictionary {

    boolean isAlienSorted(String[] words, String order);

    class VerifyingAlienDictionaryRev1 implements VerifyingAlienDictionary {

        public boolean isAlienSorted(String[] words, String order) {
            int[] positions = positions(order);
            for (int i = 1; i < words.length; i++) {
                if (!lexicographicallyOrdered(words[i - 1], words[i], positions)) {
                    return false;
                }
            }
            return true;
        }

        private int[] positions(String order) {
            int[] positions = new int[26];
            for (int i = 0; i < positions.length; i++) {
                char c = order.charAt(i);
                positions[c - 'a'] = i;
            }
            return positions;
        }

        private boolean lexicographicallyOrdered(String s1, String s2, int[] positions) {
            for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                int pos1 = positions[s1.charAt(i) - 'a'];
                int pos2 = positions[s2.charAt(i) - 'a'];
                if (pos1 == pos2) {
                    continue;
                }
                return pos1 < pos2;
            }
            return s1.length() <= s2.length();
        }
    }
}
