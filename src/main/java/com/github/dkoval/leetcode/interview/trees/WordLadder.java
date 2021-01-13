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
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        // BFS
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        int numChanges = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String currWord = q.poll();
                visited.add(beginWord);
                char[] currWordChars = currWord.toCharArray();
                for (int i = 0; i < currWordChars.length; i++) {
                    char originalCh = currWordChars[i];
                    // generate new words by replacing i-th character with 'a'..'z'
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalCh) continue;
                        currWordChars[i] = ch;
                        String newWord = String.valueOf(currWordChars);
                        if (newWord.equals(endWord)) {
                            return numChanges + 1;
                        }
                        // add in valid non-visited word to the next level of BFS
                        if (words.contains(newWord) && !visited.contains(newWord)) {
                            q.add(newWord);
                        }
                    }
                    // restore the original i-th character before proceeding to i+1
                    currWordChars[i] = originalCh;
                }
                words.remove(currWord);
            }
            numChanges++;
        }
        return 0;
    }
}
