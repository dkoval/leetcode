package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3492/">Buddy Strings</a>
 *
 * Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B,
 * otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters
 * at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */
public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (!A.equals(B)) {
            // if there exist two indices i and j in A so that
            // A.charAt(i) == B.charAt(j) and A.charAt(j) == B.charAt(i),
            // i-th and j-th characters in A can be swapped to make A equal to B
            int i = -1, j = -1;
            for (int k = 0; k < A.length(); k++) {
                if (A.charAt(k) != B.charAt(k)) {
                    if (i == -1) {
                        i = k;
                    } else if (j == -1) {
                        j = k;
                    } else {
                        return false;
                    }
                }
            }
            return (j != -1) && A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i);
        } else {
            // if there exists a character with frequency >= 1,
            // two characters in A can be swapped to make A equal to B
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < A.length(); i++) {
                char c = A.charAt(i);
                int oldCount = count.getOrDefault(c, 0);
                if (oldCount == 1) return true;
                count.put(c, oldCount + 1);
            }
            return false;
        }
    }
}
