package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/optimal-partition-of-string/">Optimal Partition of String</a>
 * <p>
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
 * That is, no letter appears in a single substring more than once.
 * <p>
 * Return the minimum number of substrings in such a partition.
 * <p>
 * Note that each character should belong to exactly one substring in a partition.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s consists of only English lowercase letters.</li>
 * </ul>
 */
public interface OptimalPartitionOfString {

    int partitionString(String s);

    // O(N) time | O(ALPHA) = O(1) space, where ALPHA is the size of the alphabet (26 lowercase English letters)
    class OptimalPartitionOfStringRev1 implements OptimalPartitionOfString {

        @Override
        public int partitionString(String s) {
            int n = s.length();

            // greedy
            int count = 1;
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (seen.contains(c)) {
                    // start a new partition
                    count++;
                    seen = new HashSet<>();
                }
                // expand the current partition
                seen.add(c);
            }
            return count;
        }
    }
}
