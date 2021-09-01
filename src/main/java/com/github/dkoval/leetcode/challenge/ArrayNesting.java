package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/">Array Nesting</a>
 *
 * You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].
 *
 * You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
 * <ul>
 *  <li>The first element in s[k] starts with the selection of the element nums[k] of index = k.</li>
 *  <li>The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.</li>
 *  <li>We stop adding right before a duplicate element occurs in s[k].</li>
 * </ul>
 * Return the longest length of a set s[k].
 */
public interface ArrayNesting {

    int arrayNesting(int[] nums);

    // O(N) time | O(N) space
    class ArrayNestingUsingExtraSpace implements ArrayNesting {

        public int arrayNesting(int[] nums) {
            int n = nums.length;
            int longest = 1;
            boolean[] visited = new boolean[n];

            for (int x : nums) {
                if (visited[x]) {
                    continue;
                }

                int length = 1;
                visited[x] = true;
                int next = nums[x];
                while (!visited[next]) {
                    visited[next] = true;
                    next = nums[next];
                    length++;
                }
                longest = Math.max(longest, length);
            }
            return longest;
        }
    }

    // O(N) time | O(1) space
    class ArrayNestingUsingConstantSpace implements ArrayNesting {

        @Override
        public int arrayNesting(int[] nums) {
            int n = nums.length;
            int longest = 1;

            for (int i = 0; i < n; i++) {
                if (nums[i] < 0) {
                    continue;
                }

                int length = 1;
                int next = nums[nums[i]];
                nums[nums[i]] = -1; // mark as visited
                while (nums[next] >= 0) {
                    int val = nums[next];
                    nums[next] = -1;
                    next = val;
                    length++;
                }
                longest = Math.max(longest, length);
            }
            return longest;
        }
    }
}
