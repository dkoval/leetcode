package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-senior-citizens/">Number of Senior Citizens</a>
 * <p>
 * You are given a 0-indexed array of strings details. Each element of details provides information about a given passenger
 * compressed into a string of length 15. The system is such that:
 * <ul>
 *  <li>The first ten characters consist of the phone number of passengers.</li>
 *  <li>The next character denotes the gender of the person.</li>
 *  <li>The following two characters are used to indicate the age of the person.</li>
 *  <li>The last two characters determine the seat allotted to that person.</li>
 * </ul>
 * Return the number of passengers who are strictly more than 60 years old.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= details.length <= 100</li>
 *  <li>details[i].length == 15</li>
 *  <li>details[i] consists of digits from '0' to '9'.</li>
 *  <li>details[i][10] is either 'M' or 'F' or 'O'.</li>
 *  <li>The phone numbers and seat numbers of the passengers are distinct.</li>
 * </ul>
 */
public interface NumberOfSeniorCitizens {

    int countSeniors(String[] details);

    class NumberOfSeniorCitizensRev1 implements NumberOfSeniorCitizens {

        @Override
        public int countSeniors(String[] details) {
            int count = 0;
            for (String detail : details) {
                int age = (detail.charAt(11) - '0') * 10;
                age += detail.charAt(12) - '0';
                if (age > 60) {
                    count++;
                }
            }
            return count;
        }
    }
}
