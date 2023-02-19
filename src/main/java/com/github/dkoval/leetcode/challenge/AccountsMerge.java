package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/accounts-merge/">Accounts Merge</a>
 * <p>
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts.
 * Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= accounts.length <= 1000</li>
 *  <li>2 <= accounts[i].length <= 10</li>
 *  <li>1 <= accounts[i][j] <= 30</li>
 *  <li>accounts[i][0] consists of English letters</li>
 *  <li>accounts[i][j] (for j > 0) is a valid email</li>
 * </ul>
 */
public class AccountsMerge {

    // Resource: https://www.youtube.com/watch?v=6C1LxIzZUwc
    // O(N * logN) time | O(N) space
    private static class UnionFind {
        // parent[x] is the parent of x
        private final int[] parent;

        UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            while (parent[x] != x) {
                // path compression
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            parent[px] = py;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // Step #1: connect accounts that share at least one common e-mail (union-find)
        // (email -> account index) mapping
        Map<String, Integer> lookup = new HashMap<>();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            for (String email : emails) {
                if (!lookup.containsKey(email)) {
                    lookup.put(email, i);
                } else {
                    // connect 2 accounts sharing a common email
                    uf.union(i, lookup.get(email));
                }
            }
        }

        // Step #2: group emails belonging to the same account
        // (account index -> unique emails)
        Map<Integer, Set<String>> groups = new HashMap<>();
        for (List<String> account : accounts) {
            List<String> emails = account.subList(1, account.size());
            for (String email : emails) {
                int i = lookup.get(email);
                groups.computeIfAbsent(uf.find(i), __ -> new TreeSet<>()).add(email);
            }
        }

        // Now, we have all the information to return the answer
        List<List<String>> ans = new ArrayList<>(groups.size());
        for (Map.Entry<Integer, Set<String>> entry : groups.entrySet()) {
            int i = entry.getKey();
            Set<String> emails = entry.getValue();

            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0));
            account.addAll(emails);

            ans.add(account);
        }
        return ans;
    }
}
