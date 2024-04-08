package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/">Number of Students Unable to Eat Lunch</a>
 * <p>
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively.
 * All students stand in a queue. Each student either prefers square or circular sandwiches.
 * <p>
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack.
 * At each step:
 * <p>
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
 * <p>
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i-th sandwich in the stack
 * (i = 0 is the top of the stack) and students[j] is the preference of the j-th student in the initial queue
 * (j = 0 is the front of the queue). Return the number of students that are unable to eat.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= students.length, sandwiches.length <= 100</li>
 *  <li>students.length == sandwiches.length</li>
 *  <li>sandwiches[i] is 0 or 1</li>
 *  <li>students[i] is 0 or 1</li>
 * </ul>
 */
public interface NumberOfStudentsUnableToEatLunch {

    int countStudents(int[] students, int[] sandwiches);

    class NumberOfStudentsUnableToEatLunchRev1 implements NumberOfStudentsUnableToEatLunch {

        @Override
        public int countStudents(int[] students, int[] sandwiches) {
            int n = students.length;

            int i = 0;
            Queue<Integer> q = new ArrayDeque<>();
            for (int x : students) {
                if (x == sandwiches[i]) {
                    i++;
                } else {
                    q.offer(x);
                }
            }

            boolean done = q.isEmpty();
            while (!done) {
                done = true;
                int size = q.size();
                while (size-- > 0) {
                    int x = q.poll();
                    if (x == sandwiches[i]) {
                        i++;
                        done = false;
                    } else {
                        q.offer(x);
                    }
                }
            }
            return q.size();
        }
    }
}
