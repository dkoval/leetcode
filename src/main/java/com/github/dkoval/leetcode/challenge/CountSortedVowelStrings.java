package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-sorted-vowel-strings/">Count Sorted Vowel Strings</a>
 * <p>
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * <p>
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 */
public interface CountSortedVowelStrings {

    int countVowelStrings(int n);

    class CountSortedVowelStringsDPTopDown implements CountSortedVowelStrings {

        @Override
        public int countVowelStrings(int n) {
            int count = 0;
            Integer[][] memo = new Integer[n + 1][5];
            // choose the 1st vowel
            for (int i = 0; i < 5; i++) {
                count += count(n - 1, i, memo);
            }
            return count;
        }

        // last - index of the last vowel, i.e. a -> 0, e -> 1, i -> 2, o -> 3, u -> 4
        // There are 5 vowels in total.
        private int count(int n, int last, Integer[][] memo) {
            if (n == 0) {
                return 1;
            }

            if (memo[n][last] != null) {
                return memo[n][last];
            }

            int count = 0;
            for (int i = last; i < 5; i++) {
                count += count(n - 1, i, memo);
            }
            return memo[n][last] = count;
        }
    }
}
