package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-operations-to-obtain-zero/">Count Operations to Obtain Zero</a>
 * <p>
 * You are given two non-negative integers num1 and num2.
 * <p>
 * In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.
 * <p>
 * For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4.
 * However, if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
 * <p>
 * Return the number of operations required to make either num1 = 0 or num2 = 0.
 * <p>
 * Constraints:
 * <p>
 * 0 <= num1, num2 <= 10^5
 */
public interface CountOperationsToObtainZero {

    int countOperations(int num1, int num2);

    class CountOperationsToObtainZeroRev1 implements CountOperationsToObtainZero {

        @Override
        public int countOperations(int num1, int num2) {
            var count = 0;
            while (num1 != 0 && num2 != 0) {
                if (num1 >= num2) {
                    num1 -= num2;
                } else {
                    num2 -= num1;
                }
                count++;
            }
            return count;
        }
    }
}
