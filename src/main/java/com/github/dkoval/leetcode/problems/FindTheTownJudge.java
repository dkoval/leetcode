package com.github.dkoval.leetcode.problems;

public interface FindTheTownJudge {

    int findJudge(int n, int[][] trust);

    class FindTheTownJudgeByCountingEdges implements FindTheTownJudge {

        @Override
        public int findJudge(int n, int[][] trust) {
            if (n == 1) {
                return 1;
            }

            // for a vertex i,
            // counts[i][0] is the number of incoming edges
            // counts[i][1] is the number of outgoing edges
            int[][] counts = new int[n + 1][2];
            for (int[] pair : trust) {
                get(counts, pair[0])[1]++;
                get(counts, pair[1])[0]++;
            }

            for (int i = 1; i <= n; i++) {
                if (counts[i] == null) {
                    return -1;
                }

                if (counts[i][0] == n - 1 && counts[i][1] == 0) {
                    return i;
                }
            }
            return -1;
        }

        private int[] get(int[][] counts, int i) {
            if (counts[i] == null) {
                counts[i] = new int[2];
            }
            return counts[i];
        }
    }
}
