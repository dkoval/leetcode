package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/pyramid-transition-matrix/">Pyramid Transition Matrix</a>
 * <p>
 * You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter.
 * Each row of blocks contains one less block than the row beneath it and is centered on top.
 * <p>
 * To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed.
 * A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.
 * <p>
 * For example, "ABC" represents a triangular pattern with a 'C' block stacked on top of an 'A' (left) and 'B' (right) block.
 * Note that this is different from "BAC" where 'B' is on the left bottom and 'A' is on the right bottom.
 * <p>
 * You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.
 * <p>
 * Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= bottom.length <= 6</li>
 *  <li>0 <= allowed.length <= 216</li>
 *  <li>allowed[i].length == 3</li>
 *  <li>The letters in all input strings are from the set {'A', 'B', 'C', 'D', 'E', 'F'}.</li>
 *  <li>All the values of allowed are unique.</li>
 * </ul>
 */
public interface PyramidTransitionMatrix {

    boolean pyramidTransition(String bottom, List<String> allowed);

    class PyramidTransitionMatrixRev1 implements PyramidTransitionMatrix {

        @Override
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            final var n = bottom.length();

            final var patterns = new HashMap<String, List<Character>>();
            for (var s : allowed) {
                final var key = s.substring(0, 2);
                final var val = s.charAt(2);
                patterns.computeIfAbsent(key, __ -> new ArrayList<>()).add(val);
            }

            final var rows = new ArrayList<char[]>();
            rows.add(bottom.toCharArray());
            while (rows.size() < n) {
                final var size = rows.getLast().length - 1;
                rows.add(new char[size]);
            }

            return solve(rows, patterns, n, 1, 0);
        }

        private boolean solve(List<char[]> rows, Map<String, List<Character>> patterns, int n, int row, int index) {
            if (row == n) {
                return true;
            }

            if (index >= rows.get(row).length) {
                return solve(rows, patterns, n, row + 1, 0);
            }

            final var currRow = rows.get(row);
            final var prevRow = rows.get(row - 1);

            // fill the current row by trying all possibilities triangular patterns
            final var key = "" + prevRow[index] + prevRow[index + 1];
            for (var x : patterns.getOrDefault(key, List.of())) {
                currRow[index] = x;
                if (solve(rows, patterns, n, row, index + 1)) {
                    return true;
                }
                // backtrack
                currRow[index] = '#';
            }
            return false;
        }
    }

    class PyramidTransitionMatrixRev2 implements PyramidTransitionMatrix {

        @Override
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            final var n = bottom.length();

            final var patterns = new HashMap<String, List<Character>>();
            for (var s : allowed) {
                final var key = s.substring(0, 2);
                final var val = s.charAt(2);
                patterns.computeIfAbsent(key, __ -> new ArrayList<>()).add(val);
            }

            final var seen = new HashSet<String>();
            return solve(patterns, seen, bottom, "", 0);
        }

        private boolean solve(Map<String, List<Character>> patterns, Set<String> seen, String prevRow, String currRow, int index) {
            final var n = prevRow.length();

            // base case
            if (n == 1) {
                return true;
            }

            // done with the current row?
            if (index >= n - 1) {
                if (seen.contains(currRow)) {
                    return false;
                }
                seen.add(currRow);
                return solve(patterns, seen, currRow, "", 0);
            }

            final var key = prevRow.substring(index, index + 2);
            for (var x : patterns.getOrDefault(key, List.of())) {
                if (solve(patterns, seen, prevRow, currRow + x, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
