package com.github.dkoval.leetcode.mock;

/**
 * <a hreaf="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">Number of Steps to Reduce a Number to Zero</a>
 * <p>
 * Given a non-negative integer num, return the number of steps to reduce it to zero.
 * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 10^6
 */
public interface NumberOfStepsToReduceNumberToZero {

    int numberOfSteps(int num);

    class NumberOfStepsToReduceNumberToZeroStraightforward implements NumberOfStepsToReduceNumberToZero {

        @Override
        public int numberOfSteps(int num) {
            int numSteps = 0;
            while (num != 0) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num--;
                }
                numSteps++;
            }
            return numSteps;
        }
    }
}
