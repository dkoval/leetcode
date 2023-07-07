package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">Maximize the Confusion of an Exam</a>
 * <p>
 * A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false.
 * He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 * <p>
 * You are given a string answerKey, where answerKey[i] is the original answer to the ith question.
 * In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 * <p>
 * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == answerKey.length</li>
 *  <li>1 <= n <= 5 * 10^4</li>
 *  <li>answerKey[i] is either 'T' or 'F'</li>
 *  <li>1 <= k <= n</li>
 * </ul>
 */
public interface MaximizeConfusionOfExam {

    int maxConsecutiveAnswers(String answerKey, int k);

    class MaximizeConfusionOfExamRev1 implements MaximizeConfusionOfExam {

        @Override
        public int maxConsecutiveAnswers(String answerKey, int k) {
            return Math.max(calculate(answerKey, k, 'T'), calculate(answerKey, k, 'F'));
        }

        private int calculate(String answerKey, int k, char correct) {
            int n = answerKey.length();

            // Idea: sliding window
            int start = 0;
            int end = 0;

            int best = 0;
            int changes = 0;
            while (end < n) {
                if (answerKey.charAt(end) != correct) {
                    changes++;
                }

                // too many changes done, try shrinking the sliding window
                while (changes > k) {
                    if (answerKey.charAt(start) != correct) {
                        changes--;
                    }
                    start++;
                }

                best = Math.max(best, end - start + 1);
                end++;
            }
            return best;
        }
    }
}
