package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/replace-words/">Replace Words</a>
 * <p>
 * In English, we have a concept called root, which can be followed by some other word to form another longer word -
 * let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a
 * derivative "helpful".
 * <p>
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all
 * the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 * <p>
 * Return the sentence after the replacement.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= dictionary.length <= 1000</li>
 *  <li>1 <= dictionary[i].length <= 100</li>
 *  <li>dictionary[i] consists of only lower-case letters.</li>
 *  <li>1 <= sentence.length <= 106</li>
 *  <li>sentence consists of only lower-case letters and spaces.</li>
 *  <li>The number of words in sentence is in the range [1, 1000]</li>
 *  <li>The length of each word in sentence is in the range [1, 1000]</li>
 *  <li>Every two consecutive words in sentence will be separated by exactly one space.</li>
 *  <li>sentence does not have leading or trailing spaces.</li>
 * </ul>
 */
public interface ReplaceWords {

    String replaceWords(List<String> dictionary, String sentence);

    class ReplaceWordsRev1 implements ReplaceWords {

        @Override
        public String replaceWords(List<String> dictionary, String sentence) {
            Trie t = new Trie(dictionary);
            String[] words = sentence.split(" ");

            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }

                String root = t.getRootOf(word);
                sb.append(Objects.requireNonNullElse(root, word));
            }
            return sb.toString();
        }

        private static class Trie {
            final Node root = new Node();

            Trie(List<String> words) {
                for (String word : words) {
                    Node curr = root;
                    for (int i = 0; i < word.length(); i++) {
                        curr = curr.branches.computeIfAbsent(word.charAt(i), __ -> new Node());
                    }
                    curr.isWord = true;
                }
            }

            String getRootOf(String word) {
                StringBuilder sb = new StringBuilder();
                Node curr = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!curr.branches.containsKey(c)) {
                        return null;
                    }

                    sb.append(c);
                    curr = curr.branches.get(c);

                    if (curr.isWord) {
                        break;
                    }
                }
                return sb.toString();
            }

            static class Node {
                final Map<Character, Node> branches = new HashMap<>();
                boolean isWord;
            }
        }
    }
}
