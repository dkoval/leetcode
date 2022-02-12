package com.github.dkoval.leetcode.interview.trees;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3068/">Word Ladder</a>
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
 */
public class WordLadder {

    // Resource: https://www.youtube.com/watch?v=5iFZP-f40iI
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        // BFS to find the shortest path from source = beginWord to target = endWord
        int count = 1;
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            while (size-- > 0) {
                String word = q.poll();
                // generate new words be replacing word[i] char with a..z
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) {
                            continue;
                        }

                        chars[i] = c;
                        String newWord = String.valueOf(chars);
                        if (newWord.equals(endWord)) {
                            return count;
                        }

                        // add in valid non-visited word to the next level of
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    // restore word[i] char before proceeding to i + 1
                    chars[i] = orig;
                }
            }
        }
        return 0;
    }
}
