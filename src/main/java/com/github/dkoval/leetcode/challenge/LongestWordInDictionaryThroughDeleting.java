package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3649/">Longest Word in Dictionary through Deleting</a>
 * <p>
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
 * some characters of the given string. If there are more than one possible results, return the longest word with
 * the smallest lexicographical order. If there is no possible result, return the empty string.
 */
public class LongestWordInDictionaryThroughDeleting {

    private static class CharPointer {
        final int wordIndex;
        final int charIndex;

        CharPointer(int wordIndex, int charIndex) {
            this.wordIndex = wordIndex;
            this.charIndex = charIndex;
        }
    }

    public String findLongestWord(String s, List<String> d) {
        Map<Character, Queue<CharPointer>> lookup = new HashMap<>();
        for (int i = 0; i < d.size(); i++) {
            char firstChar = d.get(i).charAt(0);
            lookup.computeIfAbsent(firstChar, key -> new LinkedList<>()).offer(
                    new CharPointer(i, 0));
        }

        int longestWordIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            Queue<CharPointer> q = lookup.get(currChar);
            if (q == null) {
                continue;
            }

            int size = q.size();
            while (size-- > 0) {
                CharPointer ptr = q.poll();
                String currWord = d.get(ptr.wordIndex);

                if (ptr.charIndex < currWord.length() - 1) {
                    // keep on advancing `charIndex` until it reaches the end of the `currWord`
                    int nextCharIdx = ptr.charIndex + 1;
                    char nextChar = currWord.charAt(nextCharIdx);
                    lookup.computeIfAbsent(nextChar, key -> new LinkedList<>()).offer(
                            new CharPointer(ptr.wordIndex, nextCharIdx));
                } else {
                    // `currWord` forms a subsequence in `s`
                    if (longestWordIdx == -1) {
                        longestWordIdx = ptr.wordIndex;
                    } else {
                        String longestWordSoFar = d.get(longestWordIdx);
                        if (currWord.length() > longestWordSoFar.length()
                                /* if lengths are the same, take a word with the smallest lexicographical order */
                                || (currWord.length() == longestWordSoFar.length() && currWord.compareTo(longestWordSoFar) < 1)) {
                            longestWordIdx = ptr.wordIndex;
                        }
                    }
                }
            }
        }
        return (longestWordIdx == -1) ? "" : d.get(longestWordIdx);
    }
}
