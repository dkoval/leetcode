package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/defuse-the-bomb/">Defuse the Bomb</a>
 * <p>
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 * <p>
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 * <ul>
 *  <li>If k > 0, replace the ith number with the sum of the next k numbers.</li>
 *  <li>If k < 0, replace the ith number with the sum of the previous k numbers.</li>
 *  <li>If k == 0, replace the ith number with 0.</li>
 * </ul>
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 * <p>
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == code.length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= code[i] <= 100</li>
 *  <li>-(n - 1) <= k <= n - 1</li>
 * </ul>
 */
public interface DefuseBomb {

    int[] decrypt(int[] code, int k);

    class DefuseBombRev1 implements DefuseBomb {

        private static int mod(int x, int n) {
            x %= n;
            return (x < 0) ? x + n : x;
        }

        @Override
        public int[] decrypt(int[] code, int k) {
            int n = code.length;

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int curr = i;
                int step = (k > 0) ? 1 : -1;
                int repeat = Math.abs(k);
                while (repeat > 0) {
                    curr += step;
                    sum += code[mod(curr, n)];
                    repeat--;
                }
                ans[i] = sum;
            }
            return ans;
        }
    }

    class DefuseBombRev2 implements DefuseBomb {

        @Override
        public int[] decrypt(int[] code, int k) {
            int n = code.length;

            int[] ans = new int[n];
            if (k == 0) {
                return ans;
            }

            // idea: maintain the sum of k-sized window
            int left = (k > 0) ? 1 : n + k;
            int right = left - 1;

            // get the sum of the 1st window
            int sum = 0;
            int repeat = Math.abs(k);
            while (repeat-- > 0) {
                sum += code[++right];
            }

            ans[0] = sum;
            for (int i = 1; i < n; i++) {
                // exclude the 1st element of the previous window
                sum -= code[left];
                left = (left + 1) % n;
                right = (right + 1) % n;
                // include the last element of the current window
                sum += code[right];
                ans[i] = sum;
            }
            return ans;
        }
    }
}
