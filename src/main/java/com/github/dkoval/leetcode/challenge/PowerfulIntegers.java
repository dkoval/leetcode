package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3726/">Powerful Integers</a>
 * <p>
 * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
 * <p>
 * An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
 * <p>
 * You may return the answer in any order. In your answer, each value should occur at most once.
 */
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (bound < 2) {
            return Collections.emptyList();
        }

        // Generate all possible sums x^i + y^j <= bound, where i >= 0, j >= 0
        Set<Integer> result = new HashSet<>();
        int xs = 1; // x^0 = 1
        while (xs + 1 <= bound) {
            int ys = 1; // y^0 = 1
            while (xs + ys <= bound) {
                result.add(xs + ys);
                if (y == 1) break;
                ys *= y;
            }
            if (x == 1) break;
            xs *= x;
        }
        return new ArrayList<>(result);
    }
}
