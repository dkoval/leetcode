package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-valid-words-for-each-puzzle">Number of Valid Words for Each Puzzle (Hard)</a>
 * <p>
 * With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
 * <ul>
 *   <li>word contains the first letter of puzzle.</li>
 *   <li>For each letter in word, that letter is in puzzle.</li>
 *   <ul>
 *     <li>For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage", while</li>
 *     <li>invalid words are "beefed" (does not include 'a') and "based" (includes 's' which is not in the puzzle).</li>
 *   </ul>
 * </ul>
 * Return an array answer, where answer[i] is the number of words in the given word list words that is valid with respect to the puzzle puzzles[i].
 * <p>
 * Constraints:
 * <ul>
 *   <li>1 <= words.length <= 105</li>
 *   <li>4 <= words[i].length <= 50</li>
 *   <li>1 <= puzzles.length <= 104</li>
 *   <li>puzzles[i].length == 7</li>
 *   <li>words[i] and puzzles[i] consist of lowercase English letters.</li>
 *   <li>Each puzzles[i] does not contain repeated characters.</li>
 * </ul>
 */
public class NumberOfValidWordsForEachPuzzle {

    // Resource: https://www.youtube.com/watch?v=t1MSHVZLPNY
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // Group words that contain the same letters:
        // (key = bitmask, value = count)
        // bitmask: 0th bit -> 'a', 1st bit -> 'b', ... 25th bit -> 'z'
        Map<Integer, Integer> maskCounts = new HashMap<>();
        for (String word : words) {
            int mask = includedCharsMask(word);
            maskCounts.put(mask, maskCounts.getOrDefault(mask, 0) + 1);
        }

        // Count the number of valid words for each puzzles[i].
        // To do so, consider all possible subsets of a puzzles[i]:
        // puzzles[i].length == 7, therefore total number of possible subsets is 2^7 = 128 - not too big.
        List<Integer> ans = new ArrayList<>(puzzles.length);
        for (String puzzle : puzzles) {
            // requirement: word must contain the first letter of puzzles[i]
            int mask = 1 << (puzzle.charAt(0) - 'a');
            int count = countMatchingSubsets(puzzle, 1, mask, maskCounts);
            ans.add(count);
        }
        return ans;
    }

    private int includedCharsMask(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }

    private int countMatchingSubsets(String s, int idx, int mask, Map<Integer, Integer> maskCounts) {
        if (idx == s.length()) {
            return maskCounts.getOrDefault(mask, 0);
        }

        int count = 0;
        // option #1: take s[idx] character
        count += countMatchingSubsets(s, idx + 1, mask | (1 << (s.charAt(idx) - 'a')), maskCounts);
        // option #2: skip s[idx] character
        count += countMatchingSubsets(s, idx + 1, mask, maskCounts);

        return count;
    }
}
