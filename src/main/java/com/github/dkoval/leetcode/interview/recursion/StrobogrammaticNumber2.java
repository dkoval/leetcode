package com.github.dkoval.leetcode.interview.recursion;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/62/recursion-4/399/">Strobogrammatic Number II</a>
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Find all strobogrammatic numbers that are of length = n.
 */
public abstract class StrobogrammaticNumber2 {

    public abstract List<String> findStrobogrammatic(int n);

    public static class StrobogrammaticNumber2RecursiveOvercomplicated extends StrobogrammaticNumber2 {

        private static final Map<Character, Character> mapping = new HashMap<>();
        static {
            mapping.put('0', '0');
            mapping.put('1', '1');
            mapping.put('6', '9');
            mapping.put('8', '8');
            mapping.put('9', '6');
        }

        @Override
        public List<String> findStrobogrammatic(int n) {
            List<String> result = new ArrayList<>();
            doFindStrobogrammatic(n, "", mapping.keySet(), result);
            return result;
        }

        private void doFindStrobogrammatic(int n, String prefix, Set<Character> availableNums, List<String> result) {
            // base cases
            if (n == 0 || n == 1) {
                String suffix = strobogramm(prefix);
                if (n == 0) {
                    result.add(prefix + suffix);
                } else {
                    result.add(prefix + '0' + suffix);
                    result.add(prefix + '1' + suffix);
                    result.add(prefix + '8' + suffix);
                }
                return;
            }
            // generate numbers
            for (char num : availableNums) {
                // '0' can't be the very first digit
                if (prefix.isEmpty() && num == '0') continue;
                doFindStrobogrammatic(
                        n - 2,
                        prefix + num,
                        availableNums,
                        result
                );
            }
        }

        private String strobogramm(String num) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num.length(); i++) {
                sb.append(mapping.get(num.charAt(i)));
            }
            return sb.reverse().toString();
        }
    }

    public static class StrobogrammaticNumber2Recursive extends StrobogrammaticNumber2 {

        @Override
        public List<String> findStrobogrammatic(int n) {
            return doFindStrobogrammatic(n, n);
        }

        private List<String> doFindStrobogrammatic(int n, int target) {
            List<String> result = new ArrayList<>();

            // base cases
            if (n == 0) {
                result.add("");
                return result;
            }
            if (n == 1) {
                result.add("0");
                result.add("1");
                result.add("8");
                return result;
            }

            // build solution to f(n) based on the solution to f(n - 2)
            List<String> prev = doFindStrobogrammatic(n - 2, target);
            for (String s : prev) {
                if (n != target) {
                    // '0' can't be the very first digit
                    result.add('0' + s + '0');
                }
                result.add('1' + s + '1');
                result.add('6' + s + '9');
                result.add('8' + s + '8');
                result.add('9' + s + '6');
            }
            return result;
        }
    }
}
