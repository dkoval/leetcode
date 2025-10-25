package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/calculate-money-in-leetcode-bank/">Calculate Money in Leetcode Bank</a>
 * <p>
 * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
 * <p>
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before.
 * On every subsequent Monday, he will put in $1 more than the previous Monday.
 * <p>
 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the n-th day.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public interface CalculateMoneyInLeetcodeBank {

    int totalMoney(int n);

    class CalculateMoneyInLeetcodeBankRev1 implements CalculateMoneyInLeetcodeBank {

        @Override
        public int totalMoney(int n) {
            var total = 0;
            var start = 0;
            var curr = 0;
            for (var i = 0; i < n; i++) {
                if (i % 7 == 0) {
                    start++;
                    curr = start;
                }
                total += curr;
                curr++;
            }
            return total;
        }
    }
}
