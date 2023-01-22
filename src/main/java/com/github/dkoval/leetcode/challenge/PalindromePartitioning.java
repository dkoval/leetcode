package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 16</li>
 *  <li>s contains only lowercase English letters.</li>
 * </ul>
 */
public interface PalindromePartitioning {

    List<List<String>> partition(String s);

    // len(s) <= 16, meaning that there are at most 16 "spaces" to put a delimiter at.
    // There can be 15, 14, ..., 1 delimiters in total, resulting in
    // C(15, 15) + C(15, 14) + ... + C(15, 1) = 2^15 number of possibilities.
    class PalindromePartitioningRev1 implements PalindromePartitioning {

        @Override
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            generate(s, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void generate(String s, int start, List<String> partition, List<List<String>> ans) {
            // base case
            if (start == s.length()) {
                ans.add(new ArrayList<>(partition));
                return;
            }

            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    // choice
                    String snippet = s.substring(start, end + 1);
                    partition.add(snippet);
                    // explore
                    generate(s, end + 1, partition, ans);
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
}
