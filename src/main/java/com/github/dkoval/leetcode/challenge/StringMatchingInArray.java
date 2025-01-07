package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/string-matching-in-an-array/">String Matching in an Array</a>
 * <p>
 * Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 30</li>
 *  <li>words[i] contains only lowercase English letters.</li>
 *  <li>All the strings of words are unique.</li>
 * </ul>
 */
public interface StringMatchingInArray {

    List<String> stringMatching(String[] words);

    class StringMatchingInArrayRev1 implements StringMatchingInArray {

        @Override
        public List<String> stringMatching(String[] words) {
            final var n = words.length;

            final var ans = new HashSet<String>();
            for (var i = 0; i < n; i++) {
                for (var j = 0; j < n; j++) {
                    if (j != i) {
                        if (substring(words[j], words[i])) {
                            ans.add(words[j]);
                        }
                    }
                }
            }
            return new ArrayList<>(ans);
        }

        // check if s1 is a substring of s2
        private boolean substring(String s1, String s2) {
            final var w1 = s1.length();
            final var w2 = s2.length();

            if (w1 > w2) {
                return false;
            }

            for (var offset = 0; offset <= w2 - w1; offset++) {
                var found = true;
                for (var i = 0; i < w1; i++) {
                    if (s1.charAt(i) != s2.charAt(i + offset)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return true;
                }
            }
            return false;
        }
    }
}
