package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3728/">Prefix and Suffix Search</a>
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

        private final Trie trie = new Trie();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                trie.add(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            return trie.search(prefix, suffix);
        }

        private static class Trie {

            static final String DELIMITER = "#";

            final Node root = new Node();

            void add(String word, int index) {
                // For a word like "test", all its possible suffixes are "test", "est", "st", "t".
                // Add all <suffix> + DELIMITER + <word> combinations to the trie, i.e.
                // "test#test", "est#test", "st#tets", "t#test"
                String wordToAdd = word + DELIMITER;
                for (int i = 0; i < wordToAdd.length() - 1; i++) {
                    Node curr = root;
                    for (int j = i; j < 2 * wordToAdd.length() - 1; j++) {
                        char c = wordToAdd.charAt(j % wordToAdd.length());
                        curr = curr.children.computeIfAbsent(c, key -> new Node());
                        curr.index = index;
                    }
                }
            }

            int search(String prefix, String suffix) {
                String prefixToSearch = suffix + DELIMITER + prefix;
                Node curr = root;
                for (int i = 0; i < prefixToSearch.length(); i++) {
                    char c = prefixToSearch.charAt(i);
                    curr = curr.children.get(c);
                    if (curr == null) {
                        return -1;
                    }
                }
                return curr.index;
            }

            static class Node {
                final Map<Character, Node> children = new HashMap<>();
                int index = -1;
            }
        }
    }
}
