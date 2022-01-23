package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> nums = new ArrayList<>();
        for (int digit = 1; digit < 10; digit++) {
            nums.add(digit);
        }

        int repeat = 9;
        while (repeat-- > 0) {
            // prepare numbers for the next iteration
            List<Integer> next = new ArrayList<>();
            for (int x : nums) {
                if (x >= low && x <= high) {
                    ans.add(x);
                }

                int lastDigit = x % 10;
                if (lastDigit < 9) {
                    next.add(x * 10 + lastDigit + 1);
                }
            }
            nums = next;
        }
        return ans;
    }
}
