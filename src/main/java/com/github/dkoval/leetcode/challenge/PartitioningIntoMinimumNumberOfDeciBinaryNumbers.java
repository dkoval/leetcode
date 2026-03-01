package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/">Partitioning Into Minimum Number Of Deci-Binary Numbers</a>
 * <p>
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n.length <= 10^5</li>
 *  <li>n consists of only digits.</li>
 *  <li>n does not contain any leading zeros and represents a positive integer.</li>
 * </ul>
 */
public interface PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    int minPartitions(String n);

    class PartitioningIntoMinimumNumberOfDeciBinaryNumbersRev1 implements PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

        @Override
        public int minPartitions(String n) {
            // Hint #1: If the input was only one digit, then you need to add up as many ones as the value of this digit.
            // Hint #2: If the input has multiple digits, then you can solve for each digit independently
            // and merge the answers to form numbers that add up to that input.
            // Hint #3: Thus the answer is equal to the max digit.
            var maxDigit = 0;
            for (var i = 0; i < n.length(); i++) {
                final var currDigit = n.charAt(i) - '0';
                maxDigit = Math.max(maxDigit, currDigit);
            }
            return maxDigit;
        }
    }
}
