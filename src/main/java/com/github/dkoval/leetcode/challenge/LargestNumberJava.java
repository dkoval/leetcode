package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberJava implements LargestNumber {

    private static class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String o1 = a + b;
            String o2 = b + a;
            return o2.compareTo(o1);
        }
    }

    @NotNull
    @Override
    public String largestNumber(@NotNull int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new LargestNumberComparator());
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
