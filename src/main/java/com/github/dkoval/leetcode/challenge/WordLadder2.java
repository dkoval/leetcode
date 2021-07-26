package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3825/">Word Ladder II</a>
 * <p>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 * <ul>
 *  <li>Every adjacent pair of words differs by a single letter.</li>
 *  <li>Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.</li>
 *  <li>sk == endWord</li>
 * </ul>
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences
 * from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned
 * as a list of the words [beginWord, s1, s2, ..., sk].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= beginWord.length <= 5</li>
 *  <li>endWord.length == beginWord.length</li>
 *  <li>1 <= wordList.length <= 1000</li>
 *  <li>wordList[i].length == beginWord.length</li>
 *  <li>beginWord, endWord, and wordList[i] consist of lowercase English letters.</li>
 *  <li>beginWord != endWord</li>
 *  <li>All the words in wordList are unique.</li>
 * </ul>
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> usedWords = new HashSet<>(wordList);
        if (!usedWords.contains(endWord)) {
            return Collections.emptyList();
        }

        // BFS
        Queue<List<String>> q = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        q.add(path);

        usedWords.remove(beginWord);
        List<List<String>> result = new ArrayList<>();
        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> wordsUsedAtCurrLevel = new HashSet<>();

            // process elements at the current level of BFS
            while (size-- > 0) {
                List<String> currPath = q.poll();
                String currWord = currPath.get(currPath.size() - 1);

                List<String> neighbors = getNeighbors(currWord, usedWords);
                for (String newWord : neighbors) {
                    List<String> newPath = new ArrayList<>(currPath);
                    newPath.add(newWord);
                    wordsUsedAtCurrLevel.add(newWord);

                    if (newWord.equals(endWord)) {
                        result.add(newPath);
                        found = true;
                    } else {
                        // add path extended with the `newWord` to the next level of BFS
                        q.add(newPath);
                    }
                }
            }

            if (found) break;
            for (String word : wordsUsedAtCurrLevel) {
                usedWords.remove(word);
            }
        }
        return result;
    }

    private List<String> getNeighbors(String word, Set<String> words) {
        List<String> result = new ArrayList<>();
        char[] chars = word.toCharArray();
        // generate new words by replacing i-th character with 'a'..'z'
        for (int i = 0; i < chars.length; i++) {
            char origCh = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == origCh) continue;
                chars[i] = ch;
                String newWord = String.valueOf(chars);
                if (words.contains(newWord)) {
                    result.add(newWord);
                }
            }
            // restore the original i-th character before proceeding to i+1
            chars[i] = origCh;
        }
        return result;
    }
}
