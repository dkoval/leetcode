package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/partition-labels/">Partition Labels</a>
 * <p>
 * You are given a string s. We want to partition the string into as many parts as possible so that
 * each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"],
 * but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 500</li>
 *  <li>s consists of lowercase English letters.</li>
 * </ul>
 */
public interface PartitionLabels {

    List<Integer> partitionLabels(String s);

    class PartitionLabelsRev1 implements PartitionLabels {

        @Override
        public List<Integer> partitionLabels(String s) {
            final var n = s.length();

            // the last occurrence of each character in the string
            final var last = new int[26];
            Arrays.fill(last, -1);

            for (var i = 0; i < n; i++) {
                last[s.charAt(i) - 'a'] = i;
            }

            // the boundaries of the current partition
            var start = 0;
            var end = 0;
            final var ans = new ArrayList<Integer>();
            for (var i = 0; i < n; i++) {
                // extend the current partition as far to the right as possible
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    // can't extend the current partition any longer
                    ans.add(end - start + 1);
                    // start a new partition
                    start = i + 1;
                }
            }
            return ans;
        }
    }
}
