package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-days-spent-together/">Count Days Spent Together</a>
 * <p>
 * Alice and Bob are traveling to Rome for separate business meetings.
 * <p>
 * You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob.
 * Alice will be in the city from the dates arriveAlice to leaveAlice (inclusive),
 * while Bob will be in the city from the dates arriveBob to leaveBob (inclusive).
 * Each will be a 5-character string in the format "MM-DD", corresponding to the month and day of the date.
 * <p>
 * Return the total number of days that Alice and Bob are in Rome together.
 * <p>
 * You can assume that all dates occur in the same calendar year, which is not a leap year.
 * Note that the number of days per month can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].
 * <p>
 * Constraints:
 * <ul>
 *  <li>All dates are provided in the format "MM-DD".</li>
 *  <li>Alice and Bob's arrival dates are earlier than or equal to their leaving dates.</li>
 *  <li>The given dates are valid dates of a non-leap year.</li>
 * </ul>
 */
public interface CountDaysSpentTogether {

    int[] DAYS_IN_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob);

    class CountDaysSpentTogetherRev1 implements CountDaysSpentTogether {

        @Override
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            final var daysBeforeOneLeaves = Math.min(countDays(leaveAlice), countDays(leaveBob));
            final var daysBeforeBothArrive = Math.max(countDays(arriveAlice), countDays(arriveBob));
            return Math.max(daysBeforeOneLeaves - daysBeforeBothArrive + 1, 0);
        }

        private int countDays(String date) {
            final var tokens = date.split("-");
            final var month = Integer.parseInt(tokens[0]);
            final var day = Integer.parseInt(tokens[1]);

            var count = day;
            for (var i = 0; i < month - 1; i++) {
                count += DAYS_IN_MONTH[i];
            }
            return count;
        }
    }
}
