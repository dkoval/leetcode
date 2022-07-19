package com.github.dkoval.leetcode.interview.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/">Pascal's Triangle</a>
 * <p>
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Constraints:
 * <p>
 * 1 <= numRows <= 30
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Collections.singletonList(1));

        for (int rowIdx = 1; rowIdx < numRows; rowIdx++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            List<Integer> prevRow = rows.get(rowIdx - 1);
            for (int i = 1; i < prevRow.size(); i++) {
                int x = prevRow.get(i - 1) + prevRow.get(i);
                currRow.add(x);
            }

            currRow.add(1);
            rows.add(currRow);
        }
        return rows;
    }
}
