package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3655/">Maximum Frequency Stack</a>
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <ul>
 *  <li>push(int x), which pushes an integer x onto the stack.</li>
 *  <li>pop(), which removes and returns the most frequent element in the stack.
 *  If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.</li>
 */
public class MaximumFrequencyStack {

    public static class FreqStack {
        private final Map<Integer, Integer> freqByNum = new HashMap<>();
        private final List<Stack<Integer>> stackByFreq = new ArrayList<>();

        public void push(int x) {
            int freq = freqByNum.getOrDefault(x, 0) + 1;
            freqByNum.put(x, freq);
            if (stackByFreq.size() < freq) {
                stackByFreq.add(new Stack<>());
            }
            stackByFreq.get(freq - 1).push(x);
        }

        public int pop() {
            Stack<Integer> stack = stackByFreq.get(stackByFreq.size() - 1);
            int x = stack.pop();
            if (stack.isEmpty()) {
                stackByFreq.remove(stackByFreq.size() - 1);
            }
            freqByNum.put(x, freqByNum.get(x) - 1);
            return x;
        }
    }
}
