package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/find-the-town-judge/"> Find the Town Judge</a>
 * <p>
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * <p>
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 * <p>
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 1000</li>
 *  <li>0 <= trust.length <= 10^4</li>
 *  <li>trust[i].length == 2</li>
 *  <li>All the pairs of trust are unique.</li>
 *  <li>ai != bi</li>
 *  <li>1 <= ai, bi <= n</li>
 * </ul>
 */
public interface FindTheTownJudge {

    int findJudge(int n, int[][] trust);

    class FindTheTownJudgeByCountingEdges implements FindTheTownJudge {

        @Override
        public int findJudge(int n, int[][] trust) {
            if (n == 1) {
                return 1;
            }

            // for every label i, count the number incoming and outgoing edges
            int[] incoming = new int[n]; // incoming[i] is the number of people who trust i
            int[] outgoing = new int[n]; // outgoing[i] is the number of people i trusts to

            for (int[] t : trust) {
                // a -> b
                incoming[t[1] - 1]++;
                outgoing[t[0] - 1]++;
            }

            for (int i = 0; i < n; i++) {
                if (outgoing[i] == 0 && incoming[i] == n - 1) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
