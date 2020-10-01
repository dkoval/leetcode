package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.Queue;

public interface NumberOfRecentCalls {

    class RecentCounterJava implements RecentCounter {
        private static final int WINDOW_SIZE = 3000;

        private final Queue<Integer> queue = new LinkedList<>();

        @Override
        public int ping(int t) {
            queue.add(t);
            Integer tmp;
            while ((tmp = queue.peek()) != null && tmp < t - WINDOW_SIZE) {
                queue.remove();
            }
            return queue.size();
        }
    }
}
