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

    interface FreqStack {

        void push(int val);

        int pop();
    }

    public static class FreqStackUsingFrequencyStacks implements FreqStack {
        // (val -> frequency) mapping
        private final Map<Integer, Integer> freqs = new HashMap<>();
        // freqStacks[i] holds a stack for storing values with frequency i
        private final List<Stack<Integer>> freqStacks = new ArrayList<>();

        @Override
        public void push(int val) {
            int freq = freqs.getOrDefault(val, 0) + 1;
            freqs.put(val, freq);
            if (freqStacks.size() < freq) {
                freqStacks.add(new Stack<>());
            }
            freqStacks.get(freq - 1).push(val);
        }

        @Override
        public int pop() {
            Stack<Integer> stack = freqStacks.get(freqStacks.size() - 1);
            int val = stack.pop();
            if (stack.isEmpty()) {
                freqStacks.remove(freqStacks.size() - 1);
            }
            freqs.put(val, freqs.get(val) - 1);
            return val;
        }
    }

    public static class FreqStackUsingMaxHeap implements FreqStack {
        // (val -> frequency) mapping
        private final Map<Integer, Integer> freqs = new HashMap<>();
        // max heap holds values sorted by their frequencies
        private final PriorityQueue<Entry> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // global monotonically increasing sequence number
        private int seqNo = 0;

        @Override
        public void push(int val) {
            int freq = freqs.getOrDefault(val, 0) + 1;
            pq.offer(new Entry(val, freq, seqNo++));
            freqs.put(val, freq);
        }

        @Override
        public int pop() {
            Entry entry = pq.poll();
            freqs.put(entry.val, freqs.get(entry.val) - 1);
            return entry.val;
        }

        private static class Entry implements Comparable<Entry> {
            final int val;
            final int freq;
            final int seqNo;

            Entry(int val, int freq, int seqNo) {
                this.val = val;
                this.freq = freq;
                this.seqNo = seqNo;
            }

            @Override
            public int compareTo(Entry that) {
                return (freq == that.freq) ? Integer.compare(seqNo, that.seqNo) : Integer.compare(freq, that.freq);
            }
        }
    }
}
