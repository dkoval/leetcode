package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/satisfiability-of-equality-equations/">Satisfiability of Equality Equations</a>
 * <p>
 * You are given an array of strings equations that represent relationships between variables where each string equations[i]
 * is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different)
 * that represent one-letter variable names.
 * <p>
 * Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= equations.length <= 500</li>
 *  <li>equations[i].length == 4</li>
 *  <li>equations[i][0] is a lowercase letter.</li>
 *  <li>equations[i][1] is either '=' or '!'.</li>
 *  <li>equations[i][2] is '='.</li>
 *  <li>equations[i][3] is a lowercase letter.</li>
 * </ul>
 */
public interface SatisfiabilityOfEqualityEquations {

    boolean equationsPossible(String[] equations);

    class SatisfiabilityOfEqualityEquationsUsingUnionFind implements SatisfiabilityOfEqualityEquations {

        @Override
        public boolean equationsPossible(String[] equations) {
            // connected components
            UnionFind uf = new UnionFind(26);

            // 1st pass: process "=="
            for (String equation : equations) {
                char op = equation.charAt(1);
                if (op == '!') {
                    continue;
                }

                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                uf.union(x, y);
            }

            // 2nd pass: process "!="
            for (String equation : equations) {
                char op = equation.charAt(1);
                if (op != '!') {
                    continue;
                }

                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if (uf.find(x) == uf.find(y)) {
                    // x == y and x != y at the same time => violation found
                    return false;
                }
            }
            return true;
        }

        private static class UnionFind {
            final int[] parent;

            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            void union(int x, int y) {
                int px = find(x);
                int py = find(y);
                parent[px] = py;
            }
        }
    }
}
