package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

public interface RotatedDigits {

    int rotatedDigits(int n);

    class RotatedDigitsRev1 implements RotatedDigits {

        private static final Set<Integer> ROTATE_TO_THEMSELVES = Set.of(0, 1, 8);
        private static final Set<Integer> CANNOT_ROTATE = Set.of(3, 4, 7);

        private static boolean containsOnly(Set<Integer> set, Set<Integer> only) {
            for (var x : set) {
                if (!only.contains(x)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int rotatedDigits(int n) {
            int count = 0;
            for (var i = 1; i <= n; i++) {
                if (canRotate(i)) {
                    count++;
                }
            }
            return count;
        }

        private boolean canRotate(int x) {
            final var rotatable = new HashSet<Integer>();
            while (x > 0) {
                final var digit = x % 10;
                if (CANNOT_ROTATE.contains(digit)) {
                    return false;
                } else {
                    rotatable.add(digit);
                }
                x /= 10;
            }

            return !containsOnly(rotatable, ROTATE_TO_THEMSELVES);
        }
    }
}
