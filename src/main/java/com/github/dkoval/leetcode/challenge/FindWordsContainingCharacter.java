package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-words-containing-character/">Find Words Containing Character</a>
 * <p>
 * You are given a 0-indexed array of strings words and a character x.
 * <p>
 * Return an array of indices representing the words that contain the character x.
 * <p>
 * Note that the returned array may be in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 50</li>
 *  <li>1 <= words[i].length <= 50</li>
 *  <li>x is a lowercase English letter.</li>
 *  <li>words[i] consists only of lowercase English letters.</li>
 * </ul>
 */
public interface FindWordsContainingCharacter {

    List<Integer> findWordsContaining(String[] words, char x);

    class FindWordsContainingCharacterRev1 implements FindWordsContainingCharacter {

        @Override
        public List<Integer> findWordsContaining(String[] words, char x) {
            final var n = words.length;

            final var ans = new ArrayList<Integer>();
            for (var i = 0; i < n; i++) {
                if (words[i].indexOf(x) != -1) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
