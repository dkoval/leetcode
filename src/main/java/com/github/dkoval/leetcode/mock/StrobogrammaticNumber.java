package com.github.dkoval.leetcode.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/strobogrammatic-number/">Strobogrammatic Number</a>
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 */
public class StrobogrammaticNumber {

    private final Map<Character, Character> lookUpsideDown = new HashMap<Character, Character>() {{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};

    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        if (n == 1) {
            char x = num.charAt(0);
            if (x != '0' && x != '1' && x != '8') {
                return false;
            }
        }
        for (int i = 0; i <= n / 2; i++) {
            char x = num.charAt(i);
            Character y = lookUpsideDown.get(x);
            if (y == null || y != num.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
