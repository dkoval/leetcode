package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-common-characters/">Find Common Characters</a>
 * <p>
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
 * You may return the answer in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 100</li>
 *  <li>words[i] consists of lowercase English letters</li>
 * </ul>
 */
public interface FindCommonCharacters {

    List<String> commonChars(String[] words);

    class FindCommonCharactersRev1 implements FindCommonCharacters {

        @Override
        public List<String> commonChars(String[] words) {
            int n = words.length;

            int[][] counts = new int[n][26];
            for (int w = 0; w < n; w++) {
                for (int i = 0; i < words[w].length(); i++) {
                    char c = words[w].charAt(i);
                    counts[w][c - 'a']++;
                }
            }

            List<String> ans = new ArrayList<>();
            for (int k = 0; k < 26; k++) {
                int seen = 0;
                int repeats = Integer.MAX_VALUE;
                for (int w = 0; w < n; w++) {
                    if (counts[w][k] == 0) {
                        continue;
                    }
                    seen++;
                    repeats = Math.min(repeats, counts[w][k]);
                }

                if (seen != n) {
                    continue;
                }

                String c = String.valueOf((char) ('a' + k));
                while (repeats-- > 0) {
                    ans.add(c);
                }
            }
            return ans;
        }
    }

    class FindCommonCharactersRev2 implements FindCommonCharacters {

        @Override
        public List<String> commonChars(String[] words) {
            int n = words.length;

            // 1 <= words.length <= 100
            // let's count the occurrences of each letter in an arbitrary word
            int[] commonCounts = counts(words[0]);

            for (int w = 1; w < n; w++) {
                int[] counts = counts(words[w]);
                for (int i = 0; i < 26; i++) {
                    commonCounts[i] = Math.min(commonCounts[i], counts[i]);
                }
            }

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (commonCounts[i] == 0) {
                    continue;
                }

                String c = String.valueOf((char) ('a' + i));
                while (commonCounts[i]-- > 0) {
                    ans.add(c);
                }
            }
            return ans;
        }

        private int[] counts(String s) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }
            return counts;
        }
    }
}
