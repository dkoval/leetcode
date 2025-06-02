package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/candy/">Candy (Hard)</a>
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == ratings.length</li>
 *  <li>1 <= n <= 2 * 10^4</li>
 *  <li>0 <= ratings[i] <= 2 * 10^4</li>
 * </ul>
 */
public interface Candy {

    int candy(int[] ratings);

    class CandyRev1 implements Candy {

        private static class IndexedValue {
            final int index;
            final int value;

            IndexedValue(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        // O(N*logN) time | O(N) space
        @Override
        public int candy(int[] ratings) {
            // Idea: sort the input array by rating in asc order but still maintain the original index i of ratings[i]
            int n = ratings.length;
            IndexedValue[] sorted = new IndexedValue[n];
            for (int i = 0; i < n; i++) {
                sorted[i] = new IndexedValue(i, ratings[i]);
            }

            Arrays.sort(sorted, Comparator.comparingInt(x -> x.value));

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                IndexedValue curr = sorted[i];
                int best = 1;

                if (curr.index - 1 >= 0 && ratings[curr.index] > ratings[curr.index - 1]) {
                    best = Math.max(best, 1 + ans[curr.index - 1]);
                }

                if (curr.index + 1 < n && ratings[curr.index] > ratings[curr.index + 1]) {
                    best = Math.max(best, 1 + ans[curr.index + 1]);
                }

                ans[curr.index] = best;
            }

            int sum = 0;
            for (int x : ans) {
                sum += x;
            }
            return sum;
        }
    }

    // O(N) time | O(N) space
    class CandyRev2 implements Candy {

        @Override
        public int candy(int[] ratings) {
            int n = ratings.length;

            int[] leftToRight = new int[n];
            int[] rightToLeft = new int[n];
            leftToRight[0] = 1;
            rightToLeft[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                // starting from index = 1, look backward
                leftToRight[i] = 1;
                if (ratings[i] > ratings[i - 1]) {
                    leftToRight[i] = leftToRight[i - 1] + 1;
                }

                // staring from index = n - 2, look forward
                rightToLeft[n - i - 1] = 1;
                if (ratings[n - i - 1] > ratings[n - i]) {
                    rightToLeft[n - i - 1] = rightToLeft[n - i] + 1;
                }
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                total += Math.max(leftToRight[i], rightToLeft[i]);
            }
            return total;
        }
    }

    // O(N) time | O(N) space
    class CandyRev3 implements Candy {

        @Override
        public int candy(int[] ratings) {
            final var n = ratings.length;

            final var candies = new int[n];
            candies[0] = 1;

            // 1st pass - going left to right
            for (var i = 1; i < n; i++) {
                candies[i] = 1;
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // 2nd pass - going right to left
            var total = candies[n - 1];
            for (var i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
                total += candies[i];
            }
            return total;
        }
    }
}
