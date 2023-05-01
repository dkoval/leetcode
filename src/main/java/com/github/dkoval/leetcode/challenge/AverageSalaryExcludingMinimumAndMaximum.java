package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/">Average Salary Excluding the Minimum and Maximum</a>
 * <p>
 * You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
 * <p>
 * Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= salary.length <= 100</li>
 *  <li>1000 <= salary[i] <= 10^6</li>
 *  <li>All the integers of salary are unique.</li>
 * </ul>
 */
public interface AverageSalaryExcludingMinimumAndMaximum {

    double average(int[] salary);

    class AverageSalaryExcludingMinimumAndMaximumRev1 implements AverageSalaryExcludingMinimumAndMaximum {

        @Override
        public double average(int[] salary) {
            int n = salary.length;

            int min = Integer.MAX_VALUE;
            int max = -1;
            int sum = 0;
            for (int x : salary) {
                sum += x;
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
            return (double)(sum - min - max) / (n - 2);
        }
    }
}
