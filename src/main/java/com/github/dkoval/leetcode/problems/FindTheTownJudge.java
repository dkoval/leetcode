package com.github.dkoval.leetcode.problems;

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
