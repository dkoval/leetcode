package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface CombinationIterator {

    String next();

    boolean hasNext();

    class CombinationIteratorRecursively implements CombinationIterator {

        private final Iterator<String> it;

        public CombinationIteratorRecursively(String characters, int combinationLength) {
            this.it = generateCombinations(characters, combinationLength).iterator();
        }

        public String next() {
            return it.next();
        }

        public boolean hasNext() {
            return it.hasNext();
        }

        private Iterable<String> generateCombinations(String chars, int length) {
            List<String> ans = new ArrayList<>();
            doGenerateCombinations(chars, length, 0, new StringBuilder(), ans);
            return ans;
        }

        private void doGenerateCombinations(String chars, int length, int idx, StringBuilder combination, List<String> ans) {
            if (length == 0) {
                ans.add(combination.toString());
                return;
            }

            for (int i = idx; i <= chars.length() - length; i++) {
                combination.append(chars.charAt(i));
                doGenerateCombinations(chars, length - 1, i + 1, combination, ans);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
