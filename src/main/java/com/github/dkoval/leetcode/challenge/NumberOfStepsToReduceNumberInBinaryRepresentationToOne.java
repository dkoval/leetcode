package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/">Number of Steps to Reduce a Number in Binary Representation to One</a>
 * <p>
 * Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under
 * the following rules:
 * <ul>
 *  <li>If the current number is even, you have to divide it by 2.</li>
 *  <li>If the current number is odd, you have to add 1 to it.</li>
 * </ul>
 * It is guaranteed that you can always reach one for all test cases.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 500</li>
 *  <li>s consists of characters '0' or '1'</li>
 *  <li>s[0] == '1'</li>
 * </ul>
 */
public interface NumberOfStepsToReduceNumberInBinaryRepresentationToOne {

    int numSteps(String s);

    // O(N) time | O(1) space
    class NumberOfStepsToReduceNumberInBinaryRepresentationToOneRev1 implements NumberOfStepsToReduceNumberInBinaryRepresentationToOne {

        @Override
        public int numSteps(String s) {
            int n = s.length();

            // idea: simulation
            int steps = 0;
            int carry = 0;
            for (int i = n - 1; i > 0; i--) {
                steps++;
                int digit = s.charAt(i) - '0' + carry;
                if (digit % 2 == 1) {
                    // Rule #2. If the current number is odd, you have to add 1 to it.
                    digit++;
                    steps++;
                }
                carry = digit / 2;
            }
            return steps + carry;
        }
    }
}
