package com.github.dkoval.leetcode.challenge;

public interface RotateArray {

    void rotate(int[] nums, int k);

    // Time complexity: O(N)
    // Space complexity: O(N)
    class RotateArrayExtraSpace implements RotateArray {

        @Override
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            if (k == 0) {
                return;
            }

            int[] answer = new int[n];
            copy(nums, n - k, answer, 0, k);
            copy(nums, 0, answer, k, n - k);
            copy(answer, 0, nums, 0, n);
        }

        private void copy(int[] src, int srcStart, int[] dst, int dstStart, int length) {
            for (int i = 0; i < length; i++) {
                dst[dstStart + i] = src[srcStart + i];
            }
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(1)
    class RotateArrayInPlace implements RotateArray {

        @Override
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            if (k == 0) {
                return;
            }

            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            int l = start, r = end;
            while (l < r) {
                int tmp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = tmp;
            }
        }
    }
}
