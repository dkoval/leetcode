package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">Find Smallest Letter Greater Than Target</a>
 * <p>
 * Given a characters array letters that is sorted in non-decreasing order and a character target,
 * return the smallest character in the array that is larger than target.
 * <p>
 * Note that the letters wrap around.
 * <p>
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= letters.length <= 10^4</li>
 *  <li>letters[i] is a lowercase English letter</li>
 *  <li>letters is sorted in non-decreasing order</li>
 *  <li>letters contains at least two different characters</li>
 *  <li>target is a lowercase English letter</li>
 * </ul>
 */
public interface FindSmallestLetterGreaterThanTarget {

    char nextGreatestLetter(char[] letters, char target);

    class FindSmallestLetterGreaterThanTargetBinarySearch implements FindSmallestLetterGreaterThanTarget {

        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;

            // wrap around rule
            if (target >= letters[right]) {
                return letters[left];
            }

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] <= target) {
                    // letters[mid] can't be a solution
                    left = mid + 1;
                } else {
                    // letters[mid] is a possible solution;
                    // check if there's a better one to the left of index mid
                    right = mid;
                }
            }
            return letters[left];
        }
    }
}
