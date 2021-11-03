package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">Ransom Note</a>
 * <p>
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Constraints:
 * <ul>
 *  <li>>1 <= ransomNote.length, magazine.length <= 10^5</li>
 *  <li>ransomNote and magazine consist of lowercase English letters</li>
 * </ul>
 */
public interface RansomNote {

    boolean canConstruct(String ransomNote, String magazine);

    // O(max(l1, l2) time | O(1) space
    class RansomNoteUsingSingleArray implements RansomNote {

        private static final int ALPHABET_SIZE = 26;

        public boolean canConstruct(String ransomNote, String magazine) {
            int l1 = ransomNote.length();
            int l2 = magazine.length();

            if (l1 > l2) {
                return false;
            }

            int[] counts = new int[ALPHABET_SIZE];
            for (int i = 0; i < l2; i++) {
                if (i < l1) {
                    counts[ransomNote.charAt(i) - 'a']++;
                }
                counts[magazine.charAt(i) - 'a']--;
            }

            for (int count : counts) {
                if (count > 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
