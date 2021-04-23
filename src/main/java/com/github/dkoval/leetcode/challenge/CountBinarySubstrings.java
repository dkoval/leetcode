package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/">Count Binary Substrings</a>
 * <p>
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        // group is a contiguous sequence of either 00...0 or 11...1
        List<Integer> groupLengths = new ArrayList<>();
        int currGroupLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                groupLengths.add(currGroupLength);
                currGroupLength = 1;
            } else {
                currGroupLength++;
            }
        }
        groupLengths.add(currGroupLength);

        int count = 0;
        for (int i = 0; i < groupLengths.size() - 1; i++) {
            count += Math.min(groupLengths.get(i), groupLengths.get(i + 1));
        }
        return count;
    }
}
