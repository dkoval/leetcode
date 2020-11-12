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
        int n = num.length();
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            char lc = num.charAt(l++);
            char rc = num.charAt(r--);
            if (lc == rc && (lc == '0' || lc == '1' || lc == '8')) continue;
            if (lc == '6' && rc == '9' || lc == '9' && rc == '6') continue;
            return false;
        }
        return true;
    }
}
