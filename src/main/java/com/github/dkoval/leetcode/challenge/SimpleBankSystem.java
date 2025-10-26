package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/simple-bank-system/">Simple Bank System</a>
 * <p>
 * You have been tasked with writing a program for a popular bank that will automate all its incoming transactions (transfer, deposit, and withdraw).
 * The bank has n accounts numbered from 1 to n. The initial balance of each account is stored in a 0-indexed integer array balance,
 * with the (i + 1)th account having an initial balance of balance[i].
 * <p>
 * Execute all the valid transactions. A transaction is valid if:
 * <p>
 * The given account number(s) are between 1 and n, and
 * The amount of money withdrawn or transferred from is less than or equal to the balance of the account.
 * Implement the Bank class:
 * <ul>
 *  <li>Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.</li>
 *  <li>boolean transfer(int account1, int account2, long money) Transfers money dollars from the account numbered account1 to the account numbered account2.
 *  Return true if the transaction was successful, false otherwise.
 *  </li>
 *  <li>boolean deposit(int account, long money) Deposit money dollars into the account numbered account.
 *  Return true if the transaction was successful, false otherwise.
 *  </li>
 *  <li>boolean withdraw(int account, long money) Withdraw money dollars from the account numbered account.
 *  Return true if the transaction was successful, false otherwise.
 *  </li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == balance.length</li>
 *  <li>1 <= n, account, account1, account2 <= 10^5</li>
 *  <li>0 <= balance[i], money <= 10^12</li>
 *  <li>At most 10^4 calls will be made to each function transfer, deposit, withdraw.</li>
 * </li>
 */
public interface SimpleBankSystem {

    class Bank {
        private final long[] balance;
        private final int n;

        public Bank(long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        private boolean validAccount(int account) {
            return account >= 1 && account <= n;
        }

        public boolean transfer(int account1, int account2, long money) {
            return validAccount(account1) && validAccount(account2) && doWithdraw(account1, money) && doDeposit(account2, money);
        }

        public boolean deposit(int account, long money) {
            return validAccount(account) && doDeposit(account, money);
        }

        private boolean doDeposit(int account, long money) {
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            return validAccount(account) && doWithdraw(account, money);
        }

        private boolean doWithdraw(int account, long money) {
            if (balance[account - 1] >= money) {
                balance[account - 1] -= money;
                return true;
            }
            return false;
        }
    }
}
