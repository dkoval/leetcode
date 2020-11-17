package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/strobogrammatic-number/">Strobogrammatic Number</a>
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length() - 1;
        while (i <= j) {
            char c1 = num.charAt(i++);
            char c2 = num.charAt(j--);
            if (!isStrobogrammaticPair(c1, c2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrobogrammaticPair(char c1, char c2) {
        if (c1 == c2) {
            return (c1 == '0') || (c1 == '1') || (c1 == '8');
        } else {
            return (c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6');
        }
    }
}
