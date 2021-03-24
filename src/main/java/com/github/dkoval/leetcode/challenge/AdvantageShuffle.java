package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3683/">Advantage Shuffle</a>
 * <p>
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * <p>
 * Return any permutation of A that maximizes its advantage with respect to B.
 */
public class AdvantageShuffle {

    // O(NlogN) time | O(N) space
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;

        Map<Integer, Queue<Integer>> origNumIndicesInB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            origNumIndicesInB.computeIfAbsent(B[i], key -> new LinkedList<>()).add(i);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] result = new int[n];
        Arrays.fill(result, -1);
        Queue<Integer> unused = new LinkedList<>();

        int j = 0;
        for (int a : A) {
            int b = B[j];
            if (a > b) {
                int origNumIndexInB = origNumIndicesInB.get(b).poll();
                result[origNumIndexInB] = a;
                j++;
            } else {
                unused.offer(a);
            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == -1) {
                result[i] = unused.poll();
            }
        }
        return result;
    }
}
