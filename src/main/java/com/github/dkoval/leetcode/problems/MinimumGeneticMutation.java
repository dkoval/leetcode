package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-genetic-mutation/">Minimum Genetic Mutation</a>
 * <p>
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * <p>
 * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined
 * as one single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 * <p>
 * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to
 * mutate from start to end. If there is no such a mutation, return -1.
 * <p>
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 * <p>
 * Constraints:
 * <ul>
 *  <li>start.length == 8</li>
 *  <li>end.length == 8</li>
 *  <li>0 <= bank.length <= 10</li>
 *  <li>bank[i].length == 8</li>
 *  <li>start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T']</li>
 * </ul>
 */
public interface MinimumGeneticMutation {

    int minMutation(String start, String end, String[] bank);

    class MinimumGeneticMutationBFS implements MinimumGeneticMutation {

        private static final char[] GENES = {'A', 'C', 'G', 'T'};

        @Override
        public int minMutation(String start, String end, String[] bank) {
            Set<String> valid = new HashSet<>();
            for (String gene : bank) {
                valid.add(gene);
            }

            int numMutations = 0;
            Set<String> seen = new HashSet<>();
            Queue<String> q = new ArrayDeque<>();
            q.offer(start);
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    String curr = q.poll();
                    if (curr.equals(end)) {
                        return numMutations;
                    }

                    // change a single character
                    char[] mutation = curr.toCharArray();
                    for (int i = 0; i < mutation.length; i++) {
                        char c = mutation[i];
                        for (char x : GENES) {
                            if (x != c) {
                                mutation[i] = x;
                                String newGene = String.valueOf(mutation);
                                if (valid.contains(newGene) && !seen.contains(newGene)) {
                                    seen.add(newGene);
                                    q.offer(newGene);
                                }
                            }
                        }
                        mutation[i] = c;
                    }
                }
                numMutations++;
            }
            return -1;
        }
    }
}
