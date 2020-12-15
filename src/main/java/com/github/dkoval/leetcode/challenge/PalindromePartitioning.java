package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3565/">Palindrome Partitioning</a>
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        doPartition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void doPartition(String s, int start, List<String> partition, List<List<String>> result) {
        // base case
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // choice
                String snippet = s.substring(start, end + 1);
                partition.add(snippet);
                // explore
                doPartition(s, end + 1, partition, result);
                // undo choice
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
