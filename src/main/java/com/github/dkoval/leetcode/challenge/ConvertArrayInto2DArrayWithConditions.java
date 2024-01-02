package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/">Convert an Array Into a 2D Array With Conditions</a>
 * <p>
 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 * <ul>
 *  <li>The 2D array should contain only the elements of the array nums.</li>
 *  <li>Each row in the 2D array contains distinct integers.</li>
 *  <li>The number of rows in the 2D array should be minimal.</li>
 * </ul>
 * Return the resulting array. If there are multiple answers, return any of them.
 * <p>
 * Note that the 2D array can have a different number of elements on each row.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 200</li>
 *  <li>1 <= nums[i] <= nums.length</li>
 * </ul>
 */
public interface ConvertArrayInto2DArrayWithConditions {

    List<List<Integer>> findMatrix(int[] nums);

    class ConvertArrayInto2DArrayWithConditionsRev1 implements ConvertArrayInto2DArrayWithConditions {

        @Override
        public List<List<Integer>> findMatrix(int[] nums) {
            List<Set<Integer>> rows = new ArrayList<>();
            rows.add(new LinkedHashSet<>());

            for (int x : nums) {
                boolean added = false;
                for (Set<Integer> row : rows) {
                    if (!row.contains(x)) {
                        row.add(x);
                        added = true;
                        break;
                    }
                }

                if (!added) {
                    Set<Integer> newRow = new LinkedHashSet<>();
                    newRow.add(x);
                    rows.add(newRow);
                }
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (Set<Integer> row : rows) {
                ans.add(new ArrayList<>(row));
            }
            return ans;
        }
    }
}
