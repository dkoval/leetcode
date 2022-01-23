package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SequentialDigitsGenAllInOrderIter implements SequentialDigits {

    @NotNull
    @Override
    public List<Integer> sequentialDigits(int low, int high) {
        // 1
        // 12
        // 123
        // 123...9
        //
        // 2
        // 23
        // 234
        // 234...9
        // ...
        // 8
        // 89
        //
        // 9
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> nums = new ArrayDeque<>();
        for (int digit = 1; digit < 10; digit++) {
            nums.offer(digit);
        }

        int repeat = 9;
        while (repeat-- > 0) {
            int size = nums.size();
            while (size-- > 0) {
                int x = nums.poll();
                if (x >= low && x <= high) {
                    ans.add(x);
                }

                // take numbers for the next iteration
                int lastDigit = x % 10;
                if (lastDigit < 9) {
                    nums.offer(x * 10 + lastDigit + 1);
                }
            }
        }
        return ans;
    }
}
