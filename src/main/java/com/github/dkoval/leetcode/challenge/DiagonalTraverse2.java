package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/">Diagonal Traverse II</a>
 * <p>
 * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i].length <= 10^5</li>
 *  <li>1 <= sum(nums[i].length) <= 10^5</li>
 *  <li>1 <= nums[i][j] <= 10^5</li>
 * </ul>
 */
public interface DiagonalTraverse2 {

    int[] findDiagonalOrder(List<List<Integer>> nums);

    class DiagonalTraverse2Rev1 implements DiagonalTraverse2 {

        @Override
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            // total number of diagonals = R + C - 1
            // elements lying on the same diagonal satisfy the following property:
            // row + col = d, where d is the diagonal "ID", where d in [0, R + C - 1)

            int size = 0;
            List<Deque<Integer>> diagonals = new ArrayList<>();
            for (int row = 0; row < nums.size(); row++) {
                for (int col = 0; col < nums.get(row).size(); col++) {
                    int d = row + col;
                    Deque<Integer> diagonal = (d < diagonals.size()) ? diagonals.get(d) : new ArrayDeque<>();
                    if (diagonal.isEmpty()) {
                        diagonals.add(diagonal);
                    }
                    diagonal.offerFirst(nums.get(row).get(col));
                    size++;
                }
            }

            int i = 0;
            int[] ans = new int[size];
            for (Deque<Integer> diagonal : diagonals) {
                while (!diagonal.isEmpty()) {
                    ans[i++] = diagonal.pollFirst();
                }
            }
            return ans;
        }
    }
}
