package com.github.dkoval.leetcode.interview.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/601/">Pascal's Triangle</a>
 * <p>
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Collections.singletonList(1));
        for (int rowIdx = 1; rowIdx < numRows; rowIdx++) {
            List<Integer> prevRow = rows.get(rowIdx - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int i = 1; i < rowIdx; i++) {
                currRow.add(prevRow.get(i - 1) + prevRow.get(i));
            }
            currRow.add(1);
            rows.add(currRow);
        }
        return rows;
    }
}
