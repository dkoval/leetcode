package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3498/">Repeated DNA Sequences</a>
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 */
public abstract class RepeatedDNASequences {

    public abstract List<String> findRepeatedDnaSequences(String s);

    public static class RepeatedDNASequencesStraightforward extends RepeatedDNASequences {

        private static final int WINDOW_SIZE = 10;

        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() <= WINDOW_SIZE) {
                return Collections.emptyList();
            }
            List<String> result = new ArrayList<>();
            Map<String, Integer> count = new HashMap<>();
            for (int i = 0; i <= s.length() - WINDOW_SIZE; i++) {
                String subs = s.substring(i, i + WINDOW_SIZE);
                int cnt = count.getOrDefault(subs, 0) + 1;
                count.put(subs,  cnt);
                if (cnt == 2) {
                    result.add(subs);
                }
            }
            return result;
        }
    }
}
