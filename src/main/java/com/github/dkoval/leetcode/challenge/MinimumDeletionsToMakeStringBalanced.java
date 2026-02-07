package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/">Minimum Deletions to Make String Balanced</a>
 * <p>
 * You are given a string s consisting only of characters 'a' and 'b'.
 * <p>
 * You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j)
 * such that i < j and s[i] = 'b' and s[j]= 'a'.
 * <p>
 * Return the minimum number of deletions needed to make s balanced.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 10^5</li>
 *  <li>s[i] is 'a' or 'b'</li>
 * </ul>
 */
public interface MinimumDeletionsToMakeStringBalanced {

    int minimumDeletions(String s);

    // O(N) time | O(N) space
    class MinimumDeletionsToMakeStringBalancedRev1 implements MinimumDeletionsToMakeStringBalanced {

        @Override
        public int minimumDeletions(String s) {
            final var n = s.length();

            // at any given index i, rightAs is the number of a's to the right of s[i]
            final var rightAs = new int[n];
            var countRightA = 0;
            for (var i = n - 1; i >= 0; i--) {
                rightAs[i] = countRightA;
                if (s.charAt(i) == 'a') {
                    countRightA++;
                }
            }

            var ans = n;

            // at any given index i, leftBs is the number of b's to the left of s[i]
            var leftBs = 0;
            for (var i = 0; i < n; i++) {
                ans = Math.min(ans, leftBs + rightAs[i]);
                if (s.charAt(i) == 'b') {
                    leftBs++;
                }
            }
            return ans;
        }
    }

    // O(N) time | O(1) space
    class MinimumDeletionsToMakeStringBalancedRev2 implements MinimumDeletionsToMakeStringBalanced {

        @Override
        public int minimumDeletions(String s) {
            final var n = s.length();

            // at any given index i, rightAs is the number of a's to the right of s[i]
            var rightAs = 0;
            for (var i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == 'a') {
                    rightAs++;
                }
            }

            var best = n;

            // at any given index i, leftBs is the number of b's to the left of s[i]
            var leftBs = 0;
            for (var i = 0; i < n; i++) {
                if (s.charAt(i) == 'a') {
                    rightAs--;
                }

                best = Math.min(best, leftBs + rightAs);

                if (s.charAt(i) == 'b') {
                    leftBs++;
                }
            }
            return best;
        }
    }
}
