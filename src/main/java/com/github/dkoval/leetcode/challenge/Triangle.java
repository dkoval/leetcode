package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Triangle {

    int minimumTotal(List<List<Integer>> triangle);

    // Time: O(N^2) since we're visiting all 1 + 2 + ... + N = N  * (N + 1) / 2 numbers,
    // where N is the total number of rows in the triangle
    // Space: O(1)
    class TriangleTopDown implements Triangle {

        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int numRows = triangle.size();
            for (int i = 1; i < numRows; i++) {
                int currRowNumCols = triangle.get(i).size();
                for (int j = 0; j < currRowNumCols; j++) {
                    int minPathSum = triangle.get(i).get(j);
                    // case #1: leftmost cell
                    if (j == 0) {
                        minPathSum += triangle.get(i - 1).get(0);
                    } else if (j == currRowNumCols - 1) {
                        // case #2: rightmost cell
                        int prevRowNumCols = triangle.get(i - 1).size();
                        minPathSum += triangle.get(i - 1).get(prevRowNumCols - 1);
                    } else {
                        // case #3: middle cell
                        minPathSum += Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                    }
                    // hack: store computed value in the current (i, j) position to optimize for space
                    triangle.get(i).set(j, minPathSum);
                }
            }
            // at this stage, the answer is the minimum number in the last row
            return Collections.min(triangle.get(numRows - 1));
        }
    }

    // Time: O(N^2) since we're visiting all 1 + 2 + ... + N = N  * (N + 1) / 2 numbers,
    // where N is the total number of rows in the triangle
    // Space: O(N)
    class TriangleBottomUpRev1 implements Triangle {

        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            List<Integer> row = new ArrayList<>(triangle.get(n - 1));
            // iterate over rows in reverse order
            for (int i = n - 1; i >= 1; i--) {
                // fill in (i - 1)-th row
                for (int j = 0; j < i; j++) {
                    int newVal = triangle.get(i - 1).get(j) + Math.min(row.get(j), row.get(j + 1));
                    row.set(j, newVal);
                }
            }
            return row.get(0);
        }
    }

    // Time: O(N^2) since we're visiting all 1 + 2 + ... + N = N  * (N + 1) / 2 numbers,
    // where N is the total number of rows in the triangle
    // Space: O(1)
    class TriangleBottomUpRev2 implements Triangle {

        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int minPathSum = triangle.get(i).get(j);
                    minPathSum += Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                    // hack: store computed value in the current (i, j) position to optimize for space
                    triangle.get(i).set(j, minPathSum);
                }
            }
            return triangle.get(0).get(0);
        }
    }
}