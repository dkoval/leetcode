package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/prefix-and-suffix-search/">Prefix and Suffix Search</a>
 * <p>
 * Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.
 * <p>
 * Implement the WordFilter class:
 * <ul>
 *  <li>WordFilter(string[] words) Initializes the object with the words in the dictionary.</li>
 *  <li>
 *  f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix and the suffix suffix.
 *  If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 *  </li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 15000</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>1 <= prefix.length, suffix.length <= 10</li>
 *  <li>words[i], prefix and suffix consist of lower-case English letters only</li>
 *  <li>At most 15000 calls will be made to the function f</li>
 * </ul>
 */
public class PrefixAndSuffixSearch {

    public static class WordFilter {

        static final String DELIMITER = "#";

        static class TrieNode {
            final Map<Character, TrieNode> children = new HashMap<>();
            int index = -1;
        }

        private final TrieNode root = new TrieNode();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                add(words[i], i);
            }
        }

        private void add(String word, int index) {
            // For a word "test", all its possible suffixes are "test", "est", "st", "t".
            // Add all <suffix> + DELIMITER + <word> combinations to the trie, i.e.
            // "test#test", "est#test", "st#test", "t#test"
            String s = word + DELIMITER;
            int n = s.length();
            for (int offset = 0; offset < n - 1; offset++) {
                TrieNode curr = root;
                for (int i = offset; i < 2 * n - 1; i++) {
                    char c = s.charAt(i % n);
                    curr = curr.children.computeIfAbsent(c, key -> new TrieNode());
                    curr.index = index;
                }
            }
        }

        public int f(String prefix, String suffix) {
            String prefixToSearch = suffix + DELIMITER + prefix;
            TrieNode curr = root;
            for (int i = 0; i < prefixToSearch.length(); i++) {
                char c = prefixToSearch.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return -1;
                }
                curr = curr.children.get(c);
            }
            return curr.index;
        }
    }
}
