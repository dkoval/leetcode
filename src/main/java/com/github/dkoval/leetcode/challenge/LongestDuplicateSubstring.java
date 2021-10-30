package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-duplicate-substring/">Longest Duplicate Substring (Hard)</a>
 * <p>
 * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times.
 * The occurrences may overlap.
 * <p>
 * Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= s.length <= 3 * 10^4</li>
 *  <li>s consists of lowercase English letters</li>
 * </ul>
 */
public class LongestDuplicateSubstring {
    // the size of the alphabet
    private static final int ALPHA = 26;
    // an arbitrary but large enough prime number
    private static final int PRIME = 1_000_000_1;

    // Resource: https://www.youtube.com/watch?v=BMvotl5vHvM
    public String longestDupSubstring(String s) {
        int n = s.length();

        // precompute powers of alpha: alpha^0, alpha^1, alpha^2, ..., alpha^(n - 1)
        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * ALPHA) % PRIME;
        }

        // binary search on possible substring lengths
        int l = 1;
        int r = n;
        String best = "";
        while (l <= r) {
            int mid = l + (r - l) / 2;
            String curr = rabinKarp(s, powers, mid);
            if (curr.length() > best.length()) {
                best = curr;
                // if `curr` substring of length k (= mid) is duplicated, all its prefixes,
                // i.e. curr[0 : k - 2], curr[0 : k - 3], ..., curr[0],
                // are also duplicated, therefore we can skip checking length < k
                l = mid + 1;
            } else {
                // if a duplicated substring not found for length k, there is no point in trying lengths > k
                r = mid - 1;
            }
        }
        return best;
    }

    // Returns a duplicated substring of length `length` in `s` if such a substring exists, or "" otherwise
    private String rabinKarp(String s, int[] powers, int length) {
        if (length == 0) {
            return "";
        }

        int n = s.length();

        // holds (hashCode -> substring starting index) mapping
        // hash of a string s with n characters calculates like:
        // hash = s[0] * ALPHA^(n - 1) + s[1] * ALPHA^(n - 2) + ... + s[n - 1]
        // all hash values fit in the range [0 : PRIME - 1]
        Map<Integer, List<Integer>> hashes = new HashMap<>();

        // calculate hash of the first `length` characters (initial pattern in the Robin-Karp string matching algorithm)
        int hash = 0;
        for (int i = 0; i < length; i++) {
            //hash = (hash * ALPHA + (s.charAt(i) - 'a')) % PRIME;
            hash += (s.charAt(i) - 'a') * powers[length - i - 1];
            hash %= PRIME;
        }

        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(0);
        hashes.put(hash, startIndices);

        // check all substrings of length `length` going forward (i denotes the ending index of a window of length `length`)
        for (int i = length; i < n; i++) {
            // shift window by 1 position forward and recompute hash for new s[i : i + length) characters
            // in other words, remove 1st character from the previous window, i.e. s[i - length], and add s[i] character to the current window
            hash = (hash - (s.charAt(i - length) - 'a') * powers[length - 1]) % PRIME;
            hash = (hash + PRIME) % PRIME; // handle negative hashes: -a % m = (m - a) % m, a > 0
            hash = (hash * ALPHA + (s.charAt(i) - 'a')) % PRIME;

            int startIndex = i - length + 1;
            // check if the current `pattern` equals to any previously seen substring with the same hash
            if (hashes.containsKey(hash)) {
                String pattern = s.substring(startIndex, startIndex + length);
                for (int existingStartIndex : hashes.get(hash)) {
                    String subStr = s.substring(existingStartIndex, existingStartIndex + length);
                    if (pattern.equals(subStr)) {
                        return pattern;
                    }
                }
            }
            hashes.computeIfAbsent(hash, key -> new ArrayList<>()).add(startIndex);
        }
        return "";
    }
}
