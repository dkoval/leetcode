package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3821/">Push Dominoes</a>
 * <p>
 * There are n dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * <p>
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * <p>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <p>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling
 * or already fallen domino.
 * <p>
 * You are given a string dominoes representing the initial state where:
 * <ul>
 *  <li>dominoes[i] = 'L', if the ith domino has been pushed to the left,</li>
 *  <li>dominoes[i] = 'R', if the ith domino has been pushed to the right, and</li>
 *  <li>dominoes[i] = '.', if the ith domino has not been pushed.</li>
 * </ul>
 * Return a string representing the final state.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == dominoes.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>dominoes[i] is either 'L', 'R', or '.'</li>
 * </ul>
 */
public class PushDominoes {

    // O(N) time | O(1) extra space
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] d = dominoes.toCharArray();
        int left = -1; // index of the last 'L' or 'R' domino

        int i = 0;
        while (i < n) {
            if (d[i] == 'L') {
                // Case #1.
                // Push dominoes to the left.
                int stopAtIdx = left;

                // Might need to fix half of the dominoes between d[left] == 'R' and d[i] == 'L'
                // that were previously turned to 'R'. See case #2.
                if (left != -1 && d[left] == 'R') {
                    // count dominoes between d[left] == 'R' and d[i] == 'L'
                    int count = i - left - 1;
                    stopAtIdx = i - count / 2 - 1;

                    if (count % 2 != 0) {
                        // Fix the middle domino. For example:
                        // *R* R R . L L *L*
                        //  ^      ^      ^
                        //  l      |      i
                        d[stopAtIdx] = '.';
                    }
                }

                // do push dominoes to the left
                for (int k = i - 1; k > stopAtIdx; k--) {
                    d[k] = 'L';
                }

                left = i;
                i++;
            } else if (d[i] == 'R') {
                // Case #2.
                // Push dominoes to the right as far as possible.
                // Wrongly placed 'R' dominoes will be fixed as soon as 'L' domino is discovered later on. See case #1.
                left = i;
                while (++i < n && d[i] == '.') {
                    d[i] = 'R';
                }
            } else {
                i++;
            }
        }
        return String.valueOf(d);
    }
}
