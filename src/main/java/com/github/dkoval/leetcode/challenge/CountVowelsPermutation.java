package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/count-vowels-permutation/">Count Vowels Permutation (Hard )</a>
 * <p>
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 * <ul>
 *  <li>Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')</li>
 *  <li>Each vowel 'a' may only be followed by an 'e'.</li>
 *  <li>Each vowel 'e' may only be followed by an 'a' or an 'i'.</li>
 *  <li>Each vowel 'i' may not be followed by another 'i'.</li>
 *  <li>Each vowel 'o' may only be followed by an 'i' or a 'u'.</li>
 *  <li>Each vowel 'u' may only be followed by an 'a'.</li>
 * </ul>
 * Since the answer may be too large, return it modulo 10^9 + 7
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2 * 10^4
 */
public interface CountVowelsPermutation {

    int MOD = 1_000_000_007;

    int countVowelPermutation(int n);

    class CountVowelsPermutationDPTopDown implements CountVowelsPermutation {

        private static final Map<Character, List<Character>> transitions = Map.of(
            'a', List.of('e'),
            'e', List.of('a', 'i'),
            'i', List.of('a', 'e', 'o', 'u'),
            'o', List.of('i', 'u'),
            'u', List.of('a')
        );

        @Override
        public int countVowelPermutation(int n) {
            Map<Key, Integer> dp = new HashMap<>();
            int total = 0;
            for (char c : Arrays.asList('a', 'e', 'i', 'o', 'u')) {
                total += count(c, n - 1, dp);
                total %= MOD;
            }
            return total;
        }

        private int count(char c, int n, Map<Key, Integer> dp) {
            if (n == 0) {
                return 1;
            }

            // already solved?
            Key key = new Key(c, n);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            int total = 0;
            for (char x : transitions.get(c)) {
                total += count(x, n - 1, dp);
                total %= MOD;
            }

            dp.put(key, total);
            return total;
        }

        private static class Key {
            final char c;
            final int n;

            Key(char c, int n) {
                this.c = c;
                this.n = n;
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || o.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) o;
                return (c == that.c) && (n == that.n);
            }

            public int hashCode() {
                return Objects.hash(c, n);
            }
        }
    }

    class CountVowelsPermutationDPBottomUp implements CountVowelsPermutation {
        // transitions[i] denotes the indices of vowels that can be placed after i-th vowel under the following rules:
        // - each vowel 'a' may only be followed by an 'e'.
        // - each vowel 'e' may only be followed by an 'a' or an 'i'.
        // - each vowel 'i' may not be followed by another 'i'.
        // - each vowel 'o' may only be followed by an 'i' or a 'u'.
        // - each vowel 'u' may only be followed by an 'a'.
        private static final int[][] transitions = {{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};

        @Override
        public int countVowelPermutation(int n) {
            final int numVowels = 5;

            // dp[i][j] - the number of strings of length i that ends with j-th vowel, i.e.
            // 'a' - 0, 'e' - 1, 'i' - 2, 'o' - 3, 'u' - 4
            long[][] dp = new long[n + 1][numVowels];
            for (int j = 0; j < numVowels; j++) {
                dp[1][j] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < numVowels; j++) {
                    dp[i][j] = applyRules(dp, i, j);
                }
            }

            // answer is the sum of the n-th row
            long count = 0;
            for (long x : dp[n]) {
                count += x % MOD;
            }
            return (int) (count % MOD);
        }

        private long applyRules(long[][] dp, int i, int j) {
            long count = 0;
            for (int idx : transitions[j]) {
                count += dp[i - 1][idx] % MOD;
            }
            return count % MOD;
        }
    }

    class CountVowelsPermutationDPBottomUpSpaceOptimized implements CountVowelsPermutation {
        // transitions[i] denotes the indices of vowels that can be placed after i-th vowel under the following rules:
        // - each vowel 'a' may only be followed by an 'e'.
        // - each vowel 'e' may only be followed by an 'a' or an 'i'.
        // - each vowel 'i' may not be followed by another 'i'.
        // - each vowel 'o' may only be followed by an 'i' or a 'u'.
        // - each vowel 'u' may only be followed by an 'a'.
        private static final int[][] transitions = {{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};

        @Override
        public int countVowelPermutation(int n) {
            final int numVowels = 5;
            // dp[j] - at i-th iteration, denotes the number of strings of length i that ends with j-th vowel, i.e.
            // 'a' - 0, 'e' - 1, 'i' - 2, 'o' - 3, 'u' - 4

            long[] dp = new long[numVowels];
            Arrays.fill(dp, 1);

            for (int i = 2; i <= n; i++) {
                long[] curr = new long[numVowels];
                for (int j = 0; j < numVowels; j++) {
                    curr[j] = applyRules(dp, j);
                }
                dp = curr;
            }

            // answer is the sum of the dp[]
            long count = 0;
            for (long x : dp) {
                count += x % MOD;
            }
            return (int) (count % MOD);
        }

        private long applyRules(long[] dp, int j) {
            long count = 0;
            for (int idx : transitions[j]) {
                count += dp[idx] % MOD;
            }
            return count % MOD;
        }
    }
}
