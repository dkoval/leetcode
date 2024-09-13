package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/xor-queries-of-a-subarray/">XOR Queries of a Subarray</a>
 * <p>
 * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
 * <p>
 * For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti]).
 * <p>
 * Return an array answer where answer[i] is the answer to the ith query.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length, queries.length <= 3 * 10^4</li>
 *  <li>1 <= arr[i] <= 10^9</li>
 *  <li>queries[i].length == 2</li>
 *  <li>0 <= lefti <= righti < arr.length</li>
 * </ul>
 */
public interface XORQueriesOfSubarray {

    int[] xorQueries(int[] arr, int[][] queries);

    class XORQueriesOfSubarrayRev1 implements XORQueriesOfSubarray {

        @Override
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = arr.length;
            int q = queries.length;

            // Properties of XOR
            // x ^ x = 0
            // X ^ 0 = x

            // let prefix[i] = arr[0] ^ arr[1] ^ ... ^ arr[i], then
            // XOR[i : j] = prefix[j] ^ prefix[i - 1]
            int[] prefix = new int[n];
            prefix[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] ^ arr[i];
            }

            // run queries
            int i = 0;
            int[] ans = new int[q];
            for (int[] query : queries) {
                ans[i++] = prefix[query[1]] ^ (query[0] > 0 ? prefix[query[0] - 1] : 0);
            }
            return ans;
        }
    }
}
