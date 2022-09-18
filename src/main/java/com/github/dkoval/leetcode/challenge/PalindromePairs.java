package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3777/">Palindrome Pairs</a>
 * <p>
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
 * so that the concatenation of the two words words[i] + words[j] is a palindrome.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 5000</li>
 *  <li>0 <= words[i].length <= 300</li>
 *  <li>words[i] consists of lower-case English letters</li>
 * </ul>
 */
public interface PalindromePairs {

    List<List<Integer>> palindromePairs(String[] words);

    // Produces Time Limit Exceeded error
    // O(N * M^2) time | O(N) space
    class PalindromePairsTLE implements PalindromePairs {

        @Override
        public List<List<Integer>> palindromePairs(String[] words) {
            Map<String, Integer> indices = indices(words);

            Set<List<Integer>> ans = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                for (int k = 0; k <= words[i].length(); k++) {
                    // take first k characters of words[i] and check if words[i] + reverse(prefix) is a palindrome
                    String reversedPrefix = new StringBuilder(words[i].substring(0, k)).reverse().toString();
                    if (indices.containsKey(reversedPrefix)) {
                        int j = indices.get(reversedPrefix);
                        if (i != j && isPalindrome(words[i] + reversedPrefix)) {
                            ans.add(Arrays.asList(i, j));
                        }
                    }

                    // take last k characters of words[i] and check if reverse(suffix) + words[i] is a palindrome
                    String reversedSuffix = new StringBuilder(words[i].substring(words[i].length() - k)).reverse().toString();
                    if (indices.containsKey(reversedSuffix)) {
                        int j = indices.get(reversedSuffix);
                        if (i != j && isPalindrome(reversedSuffix + words[i])) {
                            ans.add(Arrays.asList(j, i));
                        }
                    }
                }
            }
            return new ArrayList<>(ans);
        }

        private Map<String, Integer> indices(String[] words) {
            Map<String, Integer> indices = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                indices.put(words[i], i);
            }
            return indices;
        }

        private boolean isPalindrome(String s) {
            int l = 0;
            int r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

    // O(N * M^2) time | O(N) space
    // Resource: https://dev.to/seanpgallivan/solution-palindrome-pairs-23j6
    class PalindromePairsFixed implements PalindromePairs {

        @Override
        public List<List<Integer>> palindromePairs(String[] words) {
            int n = words.length;
            Map<String, Integer> indices = indices(words);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (words[i].isEmpty()) {
                    for (int j = 0; j < n; j++) {
                        // Given words[j] is a palindrome, prepending/appending "" to words[j] yields a new palindrome
                        if (i != j && isPalindrome(words[j], 0, words[j].length() - 1)) {
                            ans.add(Arrays.asList(i, j));
                            ans.add(Arrays.asList(j, i));
                        }
                    }
                } else {
                    // A full word will match on either side with its reversed version:
                    // words[i] = "abc", reverse(words[i]) = "cba"
                    // "abc|cba" and "cba|abc" are both palindromes
                    String reversedWord = new StringBuilder(words[i]).reverse().toString();
                    if (indices.containsKey(reversedWord)) {
                        int j = indices.get(reversedWord);
                        if (i != j) {
                            ans.add(Arrays.asList(i, j));
                        }
                    }

                    // A prefix of length k of a word will match with its reversed version on the opposite site
                    // if word[k : m - 1] is a palindrome.
                    //
                    // A suffix of length k of a word will match with its reversed version on the opposite site
                    // if word[0 : m - k - 1] is a palindrome.
                    //
                    // Example:
                    // words[i]          = abcdef
                    //                     --- prefix of words[i]
                    // reverse(words[i]) = fedcba
                    //                        --- reversed prefix of words[i]
                    int m = words[i].length();
                    for (int k = 1; k < m; k++) {
                        String reversedPrefix = reversedWord.substring(m - k);
                        if (indices.containsKey(reversedPrefix) && isPalindrome(words[i], k, m - 1)) {
                            int j = indices.get(reversedPrefix);
                            ans.add(Arrays.asList(i, j));
                        }

                        String reversedSuffix = reversedWord.substring(0, k);
                        if (indices.containsKey(reversedSuffix) && isPalindrome(words[i], 0, m - k - 1)) {
                            int j = indices.get(reversedSuffix);
                            ans.add(Arrays.asList(j, i));
                        }
                    }
                }
            }
            return ans;
        }

        private Map<String, Integer> indices(String[] words) {
            Map<String, Integer> indices = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                indices.put(words[i], i);
            }
            return indices;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
