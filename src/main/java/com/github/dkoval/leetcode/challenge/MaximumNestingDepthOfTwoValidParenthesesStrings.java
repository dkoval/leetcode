package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/">Maximum Nesting Depth of Two Valid Parentheses Strings</a>
 * <p>
 * A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <p>
 * depth("") = 0
 * <p>
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
 * <p>
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * <p>
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
 * The subsequences may not necessarily be contiguous.
 * <p>
 * For example, for the sequence 123456789, one possible split is:
 * <p>
 * A = {1, 3, 5, 7, 9},
 * <p>
 * B = {2, 4, 6, 8}.
 * <p>
 * This corresponds to the output [0, 1, 0, 1, 0, 1, 0, 1, 0]  where 0 indicates membership in A and 1 indicates membership in B.
 * <p>
 * Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
 * <p>
 * Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.
 * Note that even though multiple answers may exist, you may return any of them.
 */
public interface MaximumNestingDepthOfTwoValidParenthesesStrings {

    int[] maxDepthAfterSplit(String seq);

    class MaximumNestingDepthOfTwoValidParenthesesStringsRev1 implements MaximumNestingDepthOfTwoValidParenthesesStrings {

        @Override
        public int[] maxDepthAfterSplit(String seq) {
            final var n = seq.length();

            // idea: alternating
            final var res = new int[n];
            var depth = 0;
            for (var i = 0; i < n; i++) {
                if (seq.charAt(i) == '(') {
                    res[i] = depth % 2;
                    depth++;
                } else {
                    depth--;
                    res[i] = depth % 2;
                }
            }
            return res;
        }
    }
}
