package com.github.dkoval.leetcode.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/confusing-number/">Confusing Number</a>
 *
 * Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:
 *
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees,
 * they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
 */
public class ConfusingNumber {

    private final Map<Integer, Integer> rotateMap = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 1);
        put(6, 9);
        put(8, 8);
        put(9, 6);
    }};

    public boolean confusingNumber(int N) {
        int result = 0;
        int n = N;
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            if (!rotateMap.containsKey(digit)) {
                return false;
            }
            result *= 10;
            result += rotateMap.get(digit);
        }
        return result != N;
    }
}
