package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/solving-questions-with-brainpower/">Solving Questions With Brainpower</a>
 * <p>
 * You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].
 * <p>
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0)
 * and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points
 * but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.
 * <p>
 * Return the maximum points you can earn for the exam.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= questions.length <= 10^5</li>
 *  <li>questions[i].length == 2</li>
 *  <li>1 <= pointsi, brainpoweri <= 10^5</li>
 * </ul>
 */
public interface SolvingQuestionsWithBrainpower {

    long mostPoints(int[][] questions);

    // O(N) time | O(N) space
    class SolvingQuestionsWithBrainpowerDPTopDown implements SolvingQuestionsWithBrainpower {

        @Override
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            Long[] memo = new Long[n];
            return doMostPoints(questions, 0, memo);
        }

        private long doMostPoints(int[][] questions, int idx, Long[] memo) {
            if (idx >= questions.length) {
                return 0;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            int points = questions[idx][0];
            int skip = questions[idx][1];

            long pointsIfTake = points + doMostPoints(questions, idx + skip + 1, memo);
            long pointsIfSkip = doMostPoints(questions, idx + 1, memo);
            return memo[idx] = Math.max(pointsIfTake, pointsIfSkip);
        }
    }

    // O(N) time | O(N) space
    class SolvingQuestionsWithBrainpowerDPBottomUp implements SolvingQuestionsWithBrainpower {

        @Override
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                int points = questions[i][0];
                int skip = questions[i][1];

                // option #1: take questions[i]
                long pointsIfTake = points + ((i + skip + 1 < n) ? dp[i + skip + 1] : 0);
                // options #2: skip questions[i]
                long pointsIfSkip = (i + 1 < n) ? dp[i + 1] : 0;
                // take the best option
                dp[i] = Math.max(pointsIfTake, pointsIfSkip);
            }
            return dp[0];
        }
    }
}
