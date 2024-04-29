package com.github.dkoval.leetcode.challenge;

/**
 * <a hreg="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/">Minimum Number of Operations to Make Array XOR Equal to K</a>
 * <p>
 * You are given a 0-indexed integer array nums and a positive integer k.
 * <p>
 * You can apply the following operation on the array any number of times:
 * <p>
 * Choose any element of the array and flip a bit in its binary representation. Flipping a bit means changing a 0 to 1 or vice versa.
 * Return the minimum number of operations required to make the bitwise XOR of all elements of the final array equal to k.
 * <p>
 * Note that you can flip leading zero bits in the binary representation of elements.
 * For example, for the number (101)2 you can flip the fourth bit and obtain (1101)2.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>0 <= nums[i] <= 10^6</li>
 *  <li>0 <= k <= 10^6</li>
 * </ul>
 */
public interface MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    int minOperations(int[] nums, int k);

    class MinimumNumberOfOperationsToMakeArrayXOREqualToKRev1 implements MinimumNumberOfOperationsToMakeArrayXOREqualToK {

        @Override
        public int minOperations(int[] nums, int k) {
            // nums = [2, 1, 3, 4], k = 1
            // XOR(nums):
            // 010
            // 001
            // 011
            // 100
            // ---
            // x = 100 -> k = 001
            // To get the answer, we need to count bits that differ in x and k, which can be done with XOR:
            // 0 ^ 0 = 0, 1 ^ 1 = 0, 1 ^ 0 = 0 ^ 1 = 1
            int x = 0;
            for (int num : nums) {
                x ^= num;
            }

            int count = 0;
            for (int i = 0; i < 32; i++) {
                // XOR i-th bits of x and k
                int xi = (x >> i) & 1;
                int ki = (k >> i) & 1;
                count += xi ^ ki;
            }
            return count;
        }
    }

    class MinimumNumberOfOperationsToMakeArrayXOREqualToKRev2 implements MinimumNumberOfOperationsToMakeArrayXOREqualToK {

        @Override
        public int minOperations(int[] nums, int k) {
            // nums = [2, 1, 3, 4], k = 1
            // XOR(nums):
            // 010
            // 001
            // 011
            // 100
            // ---
            // x = 100 -> k = 001
            // count bits that differ in x and k (again, can be done with XOR)
            int x = 0;
            for (int num : nums) {
                x ^= num;
            }

            // to get the result, count 1-bits of x XOR k
            x ^= k;
            int count = 0;
            while (x > 0) {
                if ((x & 1) == 1) {
                    count++;
                }
                // remove the last bit of x
                x >>= 1;
            }
            return count;
        }
    }
}
