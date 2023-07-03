package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/buddy-strings/">Buddy Strings</a>
 * <p>
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 * <p>
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length, goal.length <= 2 * 10^4</li>
 *  <li>s and goal consist of lowercase letters.</li>
 * </ul>
 */
public interface BuddyStrings {

    boolean buddyStrings(String s, String goal);

    class BuddyStringsRev1 implements BuddyStrings {

        @Override
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) return false;
            if (!s.equals(goal)) {
                // if there exist two indices i and j in s so that
                // s.charAt(i) == goal.charAt(j) and s.charAt(j) == goal.charAt(i),
                // i-th and j-th characters in s can be swapped to make s equal to goal
                int i = -1, j = -1;
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) != goal.charAt(k)) {
                        if (i == -1) {
                            i = k;
                        } else if (j == -1) {
                            j = k;
                        } else {
                            return false;
                        }
                    }
                }
                return (j != -1) && s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
            } else {
                // if there exists a character with frequency >= 1,
                // two characters in s can be swapped to make s equal to goal
                Map<Character, Integer> count = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    int oldCount = count.getOrDefault(c, 0);
                    if (oldCount == 1) return true;
                    count.put(c, oldCount + 1);
                }
                return false;
            }
        }
    }

    class BuddyStringsRev2 implements BuddyStrings {

        @Override
        public boolean buddyStrings(String s, String goal) {
            int n = s.length();
            if (n != goal.length()) {
                return false;
            }

            int mismatches = 0;
            int i1 = -1;
            int i2 = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (++mismatches > 2) {
                        return false;
                    }

                    // record indices to swap characters at
                    if (i1 == -1) {
                        i1 = i;
                    } else {
                        i2 = i;
                    }
                }
            }

            if (mismatches == 1) {
                return false;
            }

            if (mismatches == 0) {
                // s = "ab", goal = "ab"       -> false
                // s = "aa", goal = "aa"       -> true (swap s[0] = 'a' and s[1] = 'a')
                // s = "abcdc", goal = "abcdc" -> true (swap s[2] = 'c' and s[4] = 'c')
                // For the answer to be true, there should be at least 1 character with the frequency >= 2
                int[] counts = new int[26];
                for (int i = 0; i < n; i++) {
                    int idx = s.charAt(i) - 'a';
                    if (++counts[idx] >= 2) {
                        return true;
                    }
                }
                return false;
            }

            // mismatches == 2
            return s.charAt(i1) == goal.charAt(i2) && s.charAt(i2) == goal.charAt(i1);
        }
    }
}
