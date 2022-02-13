package com.github.dkoval.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/">Happy Number</a>
 * <p>
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <ul>
 *  <li>Starting with any positive integer, replace the number by the sum of the squares of its digits.</li>
 *  <li>Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.</li>
 *  <li>Those numbers for which this process ends in 1 are happy.</li>
 * </ul>
 * <p>
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> seenSums = new HashSet<>();
        while (true) {
            int x = n;
            int sum = 0;
            while (x > 0) {
                int digit = x % 10;
                sum += digit * digit;
                x /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (seenSums.contains(sum)) {
                return false;
            }
            n = sum;
            seenSums.add(sum);
        }
    }
}
