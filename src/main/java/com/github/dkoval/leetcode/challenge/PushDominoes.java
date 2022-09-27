package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/push-dominoes/">Push Dominoes</a>
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
public interface PushDominoes {

    String pushDominoes(String dominoes);

    // O(N) time | O(1) extra space
    class PushDominoesRev1 implements PushDominoes {

        @Override
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

    // O(N) time | O(N) extra space
    // Resource: https://www.youtube.com/watch?v=evUFsOb_iLY
    class PushDominoesRev2 implements PushDominoes {

        @Override
        public String pushDominoes(String dominoes) {
            int n = dominoes.length();

            // collect L and R dominoes
            Queue<Domino> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = dominoes.charAt(i);
                if (c != '.') {
                    q.offer(new Domino(i, c));
                }
            }

            // simulate how L and R dominoes affect their neighbors
            char[] ans = dominoes.toCharArray();
            while (!q.isEmpty()) {
                Domino curr = q.poll();
                if (curr.direction == 'L') {
                    if (curr.index > 0 && ans[curr.index - 1] == '.') {
                        ans[curr.index - 1] = 'L';
                        q.offer(new Domino(curr.index - 1, 'L'));
                    }
                } else /*if (curr.direction == 'R')*/ {
                    // scenario #1: R.. -> RR. (current domino falls to the left)
                    // scenario #2: R.L -> R.L (vertical domino stays still due to balance of the forces)
                    if (curr.index + 1 < n && ans[curr.index + 1] == '.') {
                        if (curr.index + 2 < n && ans[curr.index + 2] == 'L') {
                            // scenario #2: no need to process L domino in the next iteration since forces are balanced
                            q.poll();
                        } else {
                            // scenario #1: current domino falls to the right
                            ans[curr.index + 1] = 'R';
                            q.offer(new Domino(curr.index + 1, 'R'));
                        }
                    }
                }
            }
            return String.valueOf(ans);
        }

        private static class Domino {
            final int index;
            final char direction;

            Domino(int index, char direction) {
                this.index = index;
                this.direction = direction;
            }
        }
    }
}
