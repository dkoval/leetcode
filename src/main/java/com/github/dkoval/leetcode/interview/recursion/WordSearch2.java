package com.github.dkoval.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/62/recursion-4/462/">Word Search II</a>
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */
public class WordSearch2 {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrieNode(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, "", result);
            }
        }
        return result;
    }

    private TrieNode buildTrieNode(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(c, key -> new TrieNode());
            }
            curr.isWord = true;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, String prefix, List<String> result) {
        // boundary check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        // is cell already visited?
        char c = board[i][j];
        if (c == '#') {
            return;
        }

        TrieNode newRoot = root.children.get(c);
        if (newRoot == null) {
            // stop backtracking immediately
            return;
        }

        String newPrefix = prefix + c;
        if (newRoot.isWord) {
            result.add(newPrefix);
            newRoot.isWord = false; // to prevent including duplicates in the result
        }

        board[i][j] = '#'; // mark cell as visited
        dfs(board, i, j + 1, newRoot, newPrefix, result); // go left
        dfs(board, i + 1, j, newRoot, newPrefix, result); // go down
        dfs(board, i, j - 1, newRoot, newPrefix, result); // go right
        dfs(board, i - 1, j, newRoot, newPrefix, result); // go up
        board[i][j] = c; // restore original letter
    }
}
