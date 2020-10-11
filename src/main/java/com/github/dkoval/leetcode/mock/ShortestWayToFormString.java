package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/shortest-way-to-form-string/">Shortest Way to Form String</a>
 *
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 *
 * Given two strings source and target, return the minimum number of subsequences of source such that
 * their concatenation equals target. If the task is impossible, return -1.
 */
public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        int count = 0;
        int j = 0;
        while (j < target.length()) {
            boolean found = false;
            for (int i = 0; i < source.length() && j < target.length(); i++) {
                if (source.charAt(i) == target.charAt(j)) {
                    found = true;
                    j++;
                }
            }
            if (!found) return -1;
            count++;
        }
        return count;
    }
}
