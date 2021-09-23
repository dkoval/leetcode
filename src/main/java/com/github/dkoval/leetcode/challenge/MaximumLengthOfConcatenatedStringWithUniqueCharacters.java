package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3984/">Maximum Length of a Concatenated String with Unique Characters</a>
 * <p>
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 16</li>
 *  <li>1 <= arr[i].length <= 26</li>
 *  <li>arr[i] contains only lower case English letters</li>
 * </ul>
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    private static class Answer {
        int maxLength = 0;
    }

    public int maxLength(List<String> arr) {
        int n = arr.size();

        // masks[i] represents unique characters we have in arr[i] string
        Integer[] masks = new Integer[n];
        for (int i = 0; i < n; i++) {
            String str = arr.get(i);
            int mask = 0;
            boolean allUnique = true;
            for (char c : str.toCharArray()) {
                int bitIdx = c - 'a';
                int charMask = (1 << bitIdx);
                if ((mask & charMask) != 0) {
                    // c is a non-unique character in arr[i]
                    allUnique = false;
                    break;
                } else {
                    mask |= charMask;
                }
            }
            masks[i] = allUnique ? mask : null;
        }

        Answer answer = new Answer();
        dfs(arr, 0, 0, masks, answer);
        return answer.maxLength;
    }

    private void dfs(List<String> arr, int idx, int mask, Integer[] masks, Answer answer) {
        if (idx == arr.size()) {
            answer.maxLength = Math.max(answer.maxLength, Integer.bitCount(mask));
            return;
        }

        // case #1: skip arr[idx] string
        dfs(arr, idx + 1, mask, masks, answer);

        // case #2: take arr[idx] string, if it doesn't lead to duplicate characters
        if (masks[idx] != null && (mask & masks[idx]) == 0) {
            dfs(arr, idx + 1, mask | masks[idx], masks, answer);
        }
    }
}
