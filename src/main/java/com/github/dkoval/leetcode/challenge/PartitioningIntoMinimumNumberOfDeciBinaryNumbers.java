package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3756/">Partitioning Into Minimum Number Of Deci-Binary Numbers</a>
 * <p>
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers
 * needed so that they sum up to n.
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        // Hint #1:  If the input was only one digit, then you need to add up as many ones as the value of this digit.
        // Hint #2: If the input has multiple digits, then you can solve for each digit independently,
        // and merge the answers to form numbers that add up to that input.
        // Hint #3: Thus the answer is equal to the max digit.
        int maxDigit = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            int currDigit = n.charAt(i) - '0';
            maxDigit = Math.max(maxDigit, currDigit);
        }
        return maxDigit;
    }
}
