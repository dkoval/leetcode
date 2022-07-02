package com.github.dkoval.leetcode.interview.trees;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-ladder/">Word Ladder</a>
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence
 * from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= beginWord.length <= 10</li>
 *  <li>endWord.length == beginWord.length</li>
 *  <li>1 <= wordList.length <= 5000</li>
 *  <li>wordList[i].length == beginWord.length</li>
 *  <li>beginWord, endWord, and wordList[i] consist of lowercase English letters</li>
 *  <li>beginWord != endWord</li>
 *  <li>All the words in wordList are unique</li>
 * </ul>
 */
public class WordLadder {

    // Resource: https://www.youtube.com/watch?v=5iFZP-f40iI
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        // BFS
        int count = 1;
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.offer(beginWord);
        seen.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();

                // replace a single letter in `curr` string
                char[] letters = curr.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    char c = letters[i];
                    for (char x = 'a'; x <= 'z'; x++) {
                        if (x != c) {
                            letters[i] = x;
                            String nextWord = String.valueOf(letters);

                            if (nextWord.equals(endWord)) {
                                return count + 1;
                            }

                            if (dict.contains(nextWord) && !seen.contains(nextWord)) {
                                q.offer(nextWord);
                                seen.add(nextWord);
                            }
                        }
                    }
                    letters[i] = c;
                }
            }
            count++;
        }
        return 0;
    }
}
