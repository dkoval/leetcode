package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/">Find the Student that Will Replace the Chalk</a>
 * <p>
 * There are n students in a class numbered from 0 to n - 1. The teacher will give each student a problem starting with the student number 0,
 * then the student number 1, and so on until the teacher reaches the student number n - 1.
 * After that, the teacher will restart the process, starting with the student number 0 again.
 * <p>
 * You are given a 0-indexed integer array chalk and an integer k. There are initially k pieces of chalk.
 * When the student number i is given a problem to solve, they will use chalk[i] pieces of chalk to solve that problem.
 * However, if the current number of chalk pieces is strictly less than chalk[i], then the student number i will be asked to replace the chalk.
 * <p>
 * Return the index of the student that will replace the chalk.
 * <p>
 * Constraints:
 * <ul>
 *  <li>chalk.length == n</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= chalk[i] <= 10^5</li>
 *  <li>1 <= k <= 10^9</li>
 * </ul>
 */
public interface FindStudentThatWillReplaceChalk {

    int chalkReplacer(int[] chalk, int k);

    // O(N) time | O(1) space
    class FindStudentThatWillReplaceChalkInLinearTime implements FindStudentThatWillReplaceChalk {

        @Override
        public int chalkReplacer(int[] chalk, int k) {
            long sum = 0;
            for (int x : chalk) {
                sum += x;
            }

            int remaining = (int)(k % sum);
            int i = 0;
            while (remaining >= chalk[i]) {
                remaining -= chalk[i];
                i++;
            }
            return i;
        }
    }

    // O(N) time | O(N) space
    class FindStudentThatWillReplaceChalkUsingPrefixSumAndBinarySearch implements FindStudentThatWillReplaceChalk {

        @Override
        public int chalkReplacer(int[] chalk, int k) {
            int n = chalk.length;

            long[] prefixSum = new long[n];
            prefixSum[0] = chalk[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + chalk[i];
            }

            // remaining chalks
            int target = (int)(k % prefixSum[n  - 1]);

            // use binary search to find the index of the smallest prefixSum[i] > target
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefixSum[mid] <= target) {
                    left = mid + 1;
                } else {
                    // mid is a possible solution;
                    // check if there is a better option to the left of index mid
                    right = mid;
                }
            }
            return left;
        }
    }
}
