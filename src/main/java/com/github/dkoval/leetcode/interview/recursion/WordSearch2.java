package com.github.dkoval.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">Word Search II</a>
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == board.length</li>
 *  <li>n == board[i].length</li>
 *  <li>1 <= m, n <= 12</li>
 *  <li>board[i][j] is a lowercase English letter.</li>
 *  <li>1 <= words.length <= 3 * 10^4</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>words[i] consists of lowercase English letters.</li>
 *  <li>All the strings of words are unique.</li>
 * </ul>
 */
public interface WordSearch2 {

    List<String> findWords(char[][] board, String[] words);

    class WordSearch2UsingTrieAndDFS implements WordSearch2 {

        private static final int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;

            Trie trie = new Trie(words);
            List<String> ans = new ArrayList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    dfs(board, row, col, trie.root, new StringBuilder(), ans);
                }
            }
            return ans;
        }

        private void dfs(char[][] board, int row, int col, Trie.Node node, StringBuilder prefix, List<String> ans) {
            char c = board[row][col];
            if (!node.branches.containsKey(c)) {
                // invalid branch
                return;
            }

            Trie.Node nextNode = node.branches.get(c);
            prefix.append(c);

            if (nextNode.isWord) {
                ans.add(prefix.toString());
                nextNode.isWord = false; // to avoid adding duplicates to the result
            }

            // DFS
            int m = board.length;
            int n = board[0].length;

            // mark the current cell as visited
            board[row][col] = '#';

            // explore adjacent cells
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (0 <= nextRow && nextRow < m && 0 <= nextCol && nextCol < n && board[nextRow][nextCol] != '#') {
                    dfs(board, nextRow, nextCol, nextNode, prefix, ans);
                }
            }

            // backtrack
            prefix.deleteCharAt(prefix.length() - 1);
            board[row][col] = c;
        }

        private static class Trie {

            final Node root = new Node();

            Trie(String[] words) {
                for (String word : words) {
                    Node curr = root;
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        curr = curr.branches.computeIfAbsent(c, __ -> new Node());
                    }
                    curr.isWord = true;
                }
            }

            static class Node {
                final Map<Character, Node> branches = new HashMap<>();
                boolean isWord;
            }
        }
    }
}
