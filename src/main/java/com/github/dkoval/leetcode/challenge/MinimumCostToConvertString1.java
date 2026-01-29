package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-convert-string-i/">Minimum Cost to Convert String I</a>
 * <p>
 * You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters.
 * You are also given two 0-indexed character arrays original and changed, and an integer array cost,
 * where cost[i] represents the cost of changing the character original[i] to the character changed[i].
 * <p>
 * You start with the string source. In one operation, you can pick a character x from the string and change it
 * to the character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.
 * <p>
 * Return the minimum cost to convert the string source to the string target using any number of operations.
 * If it is impossible to convert source to target, return -1.
 * <p>
 * Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= source.length == target.length <= 10^5</li>
 *  <li>source, target consist of lowercase English letters.</li>
 *  <li>1 <= cost.length == original.length == changed.length <= 2000</li>
 *  <li>original[i], changed[i] are lowercase English letters.</li>
 *  <li>1 <= cost[i] <= 10^6</li>
 *  <li>original[i] != changed[i]</li>
 * </ul>
 */
public interface MinimumCostToConvertString1 {

    int ALPHABET = 26;

    long minimumCost(String source, String target, char[] original, char[] changed, int[] cost);

    class MinimumCostToConvertString1Rev1 implements MinimumCostToConvertString1 {

        @Override
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            final var n = source.length();

            // dist[i][j] is the min cost to get from original[i] to changed[j]
            final var dist = floydWarshall(original, changed, cost);

            var total = 0L;
            for (var i = 0; i < n; i++) {
                final var x = source.charAt(i) - 'a';
                final var y = target.charAt(i) - 'a';

                if (dist[x][y] == Integer.MAX_VALUE) {
                    return -1;
                }

                total += dist[x][y];
            }

            return total;
        }

        private int[][] floydWarshall(char[] original, char[] changed, int[] cost) {
            final var n = original.length;

            final var dist = new int[ALPHABET][ALPHABET];
            for (var i = 0; i < ALPHABET; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                dist[i][i] = 0;
            }

            for (var i = 0; i < n; i++) {
                final var x = original[i] - 'a';
                final var y = changed[i] - 'a';
                dist[x][y] = Math.min(dist[x][y], cost[i]);
            }

            for (var k = 0; k < ALPHABET; k++) {
                for (var i = 0; i < ALPHABET; i++) {
                    for (var j = 0; j < ALPHABET; j++) {
                        if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                            continue;
                        }
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            return dist;
        }
    }
}
