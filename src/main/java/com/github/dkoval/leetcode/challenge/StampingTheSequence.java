package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/stamping-the-sequence/">Stamping The Sequence (Hard)</a>
 * <p>
 * You are given two strings stamp and target. Initially, there is a string s of length target.length with all s[i] == '?'.
 * <p>
 * In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.
 * <p>
 * For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:
 * <ul>
 *  <li>place stamp at index 0 of s to obtain "abc??",</li>
 *  <li>place stamp at index 1 of s to obtain "?abc?", or</li>
 *  <li>place stamp at index 2 of s to obtain "??abc".</li>
 * </ul>
 * Note that stamp must be fully contained in the boundaries of s in order to stamp (i.e., you cannot place stamp at index 3 of s).
 * We want to convert s to target using at most 10 * target.length turns.
 * <p>
 * Return an array of the index of the left-most letter being stamped at each turn.
 * If we cannot obtain target from s within 10 * target.length turns, return an empty array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= stamp.length <= target.length <= 1000</li>
 *  <li>stamp and target consist of lowercase English letters</li>
 * </ul>
 */
public interface StampingTheSequence {

    int[] movesToStamp(String stamp, String target);

    class StampingTheSequenceRev1 implements StampingTheSequence {

        @Override
        public int[] movesToStamp(String stamp, String target) {
            // idea: solve in reverse, i.e. convert target to s = "??...?"
            int n = target.length();
            int m = stamp.length();

            // count the number of replaced characters, i.e. those converted to '?'
            int numReplaced = 0;
            // visited[i] denotes whether the left-most letter of the stamp was put at index i
            boolean[] visited = new boolean[n];

            char[] targetChars = target.toCharArray();
            int numTurns = 0;
            List<Integer> positions = new ArrayList<>();
            while (numReplaced != n) {
                numTurns++;
                boolean stamped = false;
                // try to put a stamp at index i in target
                for (int i = 0; i <= n - m && numReplaced != n; i++) {
                    if (!visited[i] && canStamp(targetChars, i, stamp)) {
                        numReplaced += putStamp(targetChars, i, stamp);
                        visited[i] = true;
                        stamped = true;
                        positions.add(i);
                    }
                }

                if (!stamped || numTurns > 10 * n) {
                    return new int[0];
                }
            }

            int k = positions.size();
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = positions.get(k - i - 1);
            }
            return ans;
        }

        private boolean canStamp(char[] target, int idx, String stamp) {
            for (int i = 0; i < stamp.length(); i++) {
                if (target[i + idx] != '?' && target[i + idx] != stamp.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private int putStamp(char[] target, int idx, String stamp) {
            int numReplaced = 0;
            for (int i = 0; i < stamp.length(); i++) {
                if (target[i + idx] != '?') {
                    target[i + idx] = '?';
                    numReplaced++;
                }
            }
            return numReplaced;
        }
    }
}
