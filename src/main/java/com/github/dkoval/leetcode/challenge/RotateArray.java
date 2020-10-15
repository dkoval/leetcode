package com.github.dkoval.leetcode.challenge;

public abstract class RotateArray {

    public abstract void rotate(int[] nums, int k);

    // Time complexity: O(N)
    // Space complexity: O(N)
    public static class RotateArrayExtraSpace extends RotateArray {

        @Override
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            if (k == 0 || nums.length == 1) return;
            int[] answer = new int[nums.length];
            copy(nums, nums.length - k, answer, 0, k);
            copy(nums, 0, answer, k, nums.length - k);
            copy(answer, 0, nums, 0, nums.length);
        }

        private void copy(int[] src, int srcStart, int[] dst, int dstStart, int length) {
            for (int i = 0; i < length; i++) {
                dst[dstStart + i] = src[srcStart + i];
            }
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static class RotateArrayInPlace extends RotateArray {

        @Override
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            if (k == 0 || nums.length == 1) return;
            reverse(nums, 0, nums.length);
            reverse(nums, 0, k);
            reverse(nums, k, nums.length - k);
        }

        private void reverse(int[] nums, int start, int length) {
            int i = start, j = start + length - 1;
            while (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
