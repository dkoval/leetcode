package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/richest-customer-wealth/">Richest Customer Wealth</a>
 * <p>
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i-th customer has in the j-th bank.
 * Return the wealth that the richest customer has.
 * <p>
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */
public class RichestCustomerWealth {

    // O(N) time | O(1) space
    public int maximumWealth(int[][] accounts) {
        int best = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int money : account) {
                sum += money;
            }
            best = Math.max(best, sum);
        }
        return best;
    }
}
