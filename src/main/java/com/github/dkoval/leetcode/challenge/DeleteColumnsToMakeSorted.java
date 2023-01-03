package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/delete-columns-to-make-sorted/">Delete Columns to Make Sorted</a>
 * <p>
 * You are given an array of n strings strs, all of the same length.
 * <p>
 * The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:
 * <pre>
 * abc
 * bce
 * cae
 * </pre>
 * You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
 * <p>
 * Return the number of columns that you will delete.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == strs.length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= strs[i].length <= 1000</li>
 *  <li>strs[i] consists of lowercase English letters.</li>
 * </ul>
 */
public interface DeleteColumnsToMakeSorted {

    int minDeletionSize(String[] strs);

    class DeleteColumnsToMakeSortedRev1 implements DeleteColumnsToMakeSorted {

        @Override
        public int minDeletionSize(String[] strs) {
            int m = strs.length;
            int n = strs[0].length();

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
    }
}
