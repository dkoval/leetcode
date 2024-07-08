package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-the-winner-of-the-circular-game/">Find the Winner of the Circular Game</a>
 * <p>
 * There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order.
 * More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n,
 * and moving clockwise from the nth friend brings you to the 1st friend.
 * <p>
 * The rules of the game are as follows:
 * <ol>
 *  <li>Start at the 1st friend.</li>
 *  <li>Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.</li>
 *  <li>The last friend you counted leaves the circle and loses the game.</li>
 *  <li>If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.</li>
 *  <li>Else, the last friend in the circle wins the game.</li>
 * </ol>
 * <p>
 * Given the number of friends, n, and an integer k, return the winner of the game.
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= n <= 500
 */
public interface FindWinnerOfCircularGame {

    int findTheWinner(int n, int k);

    class FindWinnerOfCircularGameRev1 implements FindWinnerOfCircularGame {

        @Override
        public int findTheWinner(int n, int k) {
            if (k == 1) {
                return n;
            }

            int i = 0;
            boolean[] used = new boolean[n];
            while (n > 1) {
                // index of a player to leave
                int j = nextPlayer(i, k - 1, used);
                used[j] = true;
                n--;
                // index of the next player to continue from
                i = nextPlayer(j, 1, used);
            }
            return i + 1;
        }

        private int nextPlayer(int start, int shift, boolean[] used) {
            int n = used.length;
            int i = start;
            while (shift > 0) {
                i = (i + 1) % n;
                if (!used[i]) {
                    shift--;
                }
            }
            return i;
        }
    }

    class FindWinnerOfCircularGameRev2 implements FindWinnerOfCircularGame {

        @Override
        public int findTheWinner(int n, int k) {
            // - use a queue to model a circle
            // - at each step, move (k - 1) elements to the back of the queue,
            // then poll() to remove k-th element from the circle
            Queue<Integer> q = new ArrayDeque<>();
            for (int x = 1; x <= n; x++) {
                q.offer(x);
            }

            while (q.size() > 1) {
                // move (k - 1) elements to the back of the queue
                int repeat = k - 1;
                while (repeat-- > 0) {
                    q.offer(q.poll());
                }
                // remove k-th element
                q.poll();
            }
            return q.poll();
        }
    }
}
