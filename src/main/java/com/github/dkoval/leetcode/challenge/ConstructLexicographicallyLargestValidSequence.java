package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/">Construct the Lexicographically Largest Valid Sequence</a>
 * <p>
 * Given an integer n, find a sequence that satisfies all of the following:
 * <ul>
 *  <li>The integer 1 occurs once in the sequence.</li>
 *  <li>Each integer between 2 and n occurs twice in the sequence.</li>
 *  <li>For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.</li>
 * </ul>
 * The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.
 * <p>
 * Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.
 * <p>
 * A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ,
 * sequence a has a number greater than the corresponding number in b.
 * For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 */
public interface ConstructLexicographicallyLargestValidSequence {

    int[] constructDistancedSequence(int n);

    class ConstructLexicographicallyLargestValidSequenceRev1 implements ConstructLexicographicallyLargestValidSequence {

        @Override
        public int[] constructDistancedSequence(int n) {
            final var ans = new int[2 * n - 1];
            backtrack(n, new boolean[n + 1], ans, 0);
            return ans;
        }

        private boolean backtrack(int n, boolean[] used, int[] ans, int index) {
            // base case
            if (index == ans.length) {
                return true;
            }

            // greedy: try to put bigger numbers first
            for (var x = n; x >= 1; x--) {
                if (used[x]) {
                    continue;
                }

                if (x > 1 && (index + x >= ans.length || ans[index + x] != 0)) {
                    continue;
                }

                // place number x
                used[x] = true;
                ans[index] = x;
                if (x > 1) {
                    ans[index + x] = x;
                }

                // find next vacant index
                var nextIndex = index + 1;
                while (nextIndex < ans.length && ans[nextIndex] != 0) {
                    nextIndex++;
                }

                // proceed to the next index in ans[]
                final var done = backtrack(n, used, ans, nextIndex);
                if (done) {
                    return true;
                }

                // backtrack
                used[x] = false;
                ans[index] = 0;
                if (x > 1) {
                    ans[index + x] = 0;
                }
            }
            return false;
        }
    }
}
