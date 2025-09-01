package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/maximum-average-pass-ratio/">Maximum Average Pass Ratio</a>
 * <p>
 * There is a school that has classes of students and each class will be having a final exam.
 * You are given a 2D integer array classes, where classes[i] = [passi, totali].
 * You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
 * <p>
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to.
 * You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
 * <p>
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class.
 * The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
 * <p>
 * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= classes.length <= 10^5</li>
 *  <li>classes[i].length == 2</li>
 *  <li>1 <= passi <= totali <= 10^5</li>
 *  <li>1 <= extraStudents <= 10^5</li>
 * </ul>
 */
public interface MaximumAveragePassRatio {

    double maxAverageRatio(int[][] classes, int extraStudents);

    class MaximumAveragePassRatioRev1 implements MaximumAveragePassRatio {

        @Override
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            final var n = classes.length;

            final var maxHeap = new PriorityQueue<ClassInfo>(Comparator.comparingDouble(it -> -1 * it.change));
            for (var clazz : classes) {
                maxHeap.offer(new ClassInfo(clazz[0], clazz[1]));
            }

            while (extraStudents-- > 0) {
                final var curr = maxHeap.poll();
                maxHeap.offer(curr.addStudent());
            }

            var ans = 0.0;
            while (!maxHeap.isEmpty()) {
                final var curr = maxHeap.poll();
                System.out.println(curr);
                ans += (double) curr.pass / curr.total;
            }

            ans /= n;
            return ans;
        }

        record ClassInfo(int pass, int total, double change) {

            ClassInfo(int pass, int total) {
                this(pass, total, (double) (pass + 1) / (total + 1) - (double) pass / total);
            }

            ClassInfo addStudent() {
                return new ClassInfo(pass + 1, total + 1);
            }
        }
    }
}
