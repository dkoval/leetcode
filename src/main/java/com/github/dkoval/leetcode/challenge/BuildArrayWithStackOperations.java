package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/build-an-array-with-stack-operations/">Build an Array With Stack Operations</a>
 * <p>
 * You are given an integer array target and an integer n.
 * <p>
 * You have an empty stack with the two following operations:
 * <ul>
 *  <li>"Push": pushes an integer to the top of the stack.</li>
 *  <li>"Pop": removes the integer on the top of the stack.</li>
 * </ul>
 * You also have a stream of the integers in the range [1, n].
 * <p>
 * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target.
 * You should follow the following rules:
 * <ul>
 *  <li>If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.</li>
 *  <li>If the stack is not empty, pop the integer at the top of the stack.</li>
 *  <li>If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.</li>
 * </ul>
 * Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= target.length <= 100</li>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= target[i] <= n</li>
 *  <li>target is strictly increasing.</li>
 * </ul>
 */
public interface BuildArrayWithStackOperations {

    List<String> buildArray(int[] target, int n);

    class BuildArrayWithStackOperationsRev1 implements BuildArrayWithStackOperations {

        @Override
        public List<String> buildArray(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            int i = 0; // index of the current number in target[]
            int x = 1; // current number in the range [1, n]
            while (i < target.length) {
                // get rid of "bad" numbers
                while (x < target[i]) {
                    ans.add("Push");
                    ans.add("Pop");
                    x++;
                }
                ans.add("Push");
                i++;
                x++;
            }
            return ans;
        }
    }
}
