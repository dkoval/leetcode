package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WordSquaresRecursiveWithTrieJava implements WordSquares {

    private static class Trie {
        private final Node root = new Node();

        static class Node {
            final Map<Character, Node> children = new HashMap<>();
            String word;

            boolean isWord() {
                return word != null;
            }
        }

        Trie(String[] words) {
            for (String word : words) {
                Node curr = root;
                for (int i = 0; i < word.length(); i++) {
                    curr = curr.children.computeIfAbsent(word.charAt(i), key -> new Node());
                }
                curr.word = word;
            }
        }

        List<String> wordsWithPrefix(String prefix) {
            Node node = findNode(prefix);
            if (node == null) return Collections.emptyList();
            return collectWords(node);
        }

        private Node findNode(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                Node next = curr.children.get(prefix.charAt(i));
                if (next == null) return null;
                curr = next;
            }
            return curr;
        }

        private List<String> collectWords(Node start) {
            List<String> result = new ArrayList<>();
            doCollectWords(start, result);
            return result;
        }

        private void doCollectWords(Node node, List<String> result) {
            if (node.isWord()) {
                result.add(node.word);
                return;
            }
            for (Node child : node.children.values()) {
                doCollectWords(child, result);
            }
        }
    }

    @NotNull
    @Override
    public List<List<String>> wordSquares(@NotNull String[] words) {
        Trie trie = new Trie(words);
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            List<String> square = new ArrayList<>();
            square.add(word);
            doWordSquares(trie, square, word.length(), result);
        }
        return result;
    }

    private void doWordSquares(Trie trie, List<String> square, int length, List<List<String>> result) {
        if (square.size() == length) {
            result.add(new ArrayList<>(square));
            return;
        }
        String prefix = nextPrefix(square);
        List<String> words = trie.wordsWithPrefix(prefix);
        for (String word : words) {
            // try all words starting with `prefix`
            square.add(word);
            doWordSquares(trie, square, length, result);
            // backtrack
            square.remove(square.size() - 1);
        }
    }

    private String nextPrefix(List<String> square) {
        StringBuilder sb = new StringBuilder();
        for (String word : square) {
            sb.append(word.charAt(square.size()));
        }
        return sb.toString();
    }
}
