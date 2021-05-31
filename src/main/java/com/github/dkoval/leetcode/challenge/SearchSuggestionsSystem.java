package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3762/">Search Suggestions System</a>
 * <p>
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most
 * three product names from products after each character of searchWord is typed. Suggested products should have
 * common prefix with the searchWord. If there are more than three products with a common prefix return
 * the three lexicographically minimums products.
 * <p>
 * Return list of lists of the suggested products after each character of searchWord is typed.
 */
public class SearchSuggestionsSystem {

    private static final int MAX_SUGGESTIONS = 3;

    private static class Trie {
        final Node root = new Node();

        Trie(String[] words) {
            for (String word : words) {
                Node curr = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    curr = curr.children.computeIfAbsent(c, key -> new Node());
                    // keep at most 3 lexicographically minimum products
                    curr.suggestions.add(word);
                    Collections.sort(curr.suggestions);
                    if (curr.suggestions.size() > MAX_SUGGESTIONS) {
                        curr.suggestions.remove(MAX_SUGGESTIONS);
                    }
                }
            }
        }

        List<List<String>> suggest(String searchWord) {
            List<List<String>> result = new ArrayList<>();
            Node curr = root;
            for (int i = 0; i < searchWord.length(); i++) {
                char c = searchWord.charAt(i);
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                    result.add(curr.suggestions);
                } else {
                    result.add(Collections.emptyList());
                    break;
                }
            }

            // edge case
            while (result.size() < searchWord.length()) {
                result.add(Collections.emptyList());
            }

            return result;
        }

        static class Node {
            Map<Character, Node> children = new HashMap<>();
            List<String> suggestions = new ArrayList<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie(products);
        return trie.suggest(searchWord);
    }
}
