package com.github.dkoval.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/62/recursion-4/370/">Word Squares</a>
 * <p>
 * Given a set of words (without duplicates), find all word squares you can build from them.
 * <p>
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * <p>
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 * <pre>
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * </pre>
 * <p>
 * Note:
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 */
public class WordSquares {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            List<String> square = new ArrayList<>();
            square.add(word);
            backtrack(square, 1, words, result);
        }
        return result;
    }

    private void backtrack(List<String> square, int idx, String[] words, List<List<String>> result) {
        if (idx == square.get(0).length()) {
            result.add(new ArrayList<>(square));
            return;
        }
        String prefix = getPrefix(square, idx);
        List<String> candidates = getWordsWithPrefix(prefix, words);
        for (String candidate : candidates) {
            square.add(candidate);
            backtrack(square, idx + 1, words, result);
            square.remove(square.size() - 1);
        }
    }

    private String getPrefix(List<String> square, int idx) {
        StringBuilder sb = new StringBuilder();
        for (String word : square) {
            sb.append(word.charAt(idx));
        }
        return sb.toString();
    }

    private List<String> getWordsWithPrefix(String prefix, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }
        return result;
    }
}
