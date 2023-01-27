package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/concatenated-words/">Concatenated Words (Hard)</a>
 * <p>
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * <p>
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 10^4</li>
 *  <li>1 <= words[i].length <= 30</li>
 *  <li>words[i] consists of only lowercase English letters.</li>
 *  <li>All the strings of words are unique.</li>
 *  <li>1 <= sum(words[i].length) <= 10^5</li>
 * </ul>
 */
public interface ConcatenatedWords {

    List<String> findAllConcatenatedWordsInADict(String[] words);

    class ConcatenatedWordsRev1 implements ConcatenatedWords {

        @Override
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Set<String> lookup = Arrays.stream(words).collect(Collectors.toSet());
            List<String> ans = new ArrayList<>();
            for (String word : words) {
                if (canConcat(word, lookup)) {
                    ans.add(word);
                }
            }
            return ans;
        }

        private boolean canConcat(String word, Set<String> lookup) {
            // idea: check all possible prefixes of word
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                if (lookup.contains(prefix) && (lookup.contains(suffix) || canConcat(suffix, lookup))) {
                    return true;
                }
            }
            return false;
        }
    }
}
