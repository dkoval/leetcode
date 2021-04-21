package com.github.dkoval.leetcode.challenge;

import java.util.Collections;
import java.util.List;

public interface Triangle {

    int minimumTotal(List<List<Integer>> triangle);

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
                    // hack: store computed value in (i, j) cell to optimize for space
                    triangle.get(i).set(j, minPathSum);
                }
            }
            // at this stage, the answer is the minimum number in the last row
            return Collections.min(triangle.get(numRows - 1));
        }
    }
}