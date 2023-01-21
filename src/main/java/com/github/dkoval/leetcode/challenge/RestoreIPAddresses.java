package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/restore-ip-addresses/">Restore IP Addresses</a>
 * <p>
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive)
 * and cannot have leading zeros.
 * <p>
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s.
 * You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 20</li>
 *  <li>s consists of digits only</li>
 * </ul>
 */
public interface RestoreIPAddresses {

    List<String> restoreIpAddresses(String s);

    // We need at most 12 digits to represent a valid IP address,
    // meaning that there are 11 possible "spaces" where we need to insert 3 dots.
    // Therefore, the total number of possibilities is:
    // N = C(11, 3) = 11 * 10 * 9 / 3 * 2 * 1 = 11 * 5 * 3 = 165
    class RestoreIPAddressesRev1 implements RestoreIPAddresses {

        @Override
        public List<String> restoreIpAddresses(String s) {
            // exactly 4 integers separated by a single dot, each integer is in 0 - 255 range
            if (s.length() > 12) {
                return Collections.emptyList();
            }

            List<String> ans = new ArrayList<>();
            generate(s, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void generate(String s, int idx, List<String> nums, List<String> ans) {
            if (nums.size() > 4) {
                return;
            }

            int n = s.length();
            if (idx == n) {
                if (nums.size() == 4) {
                    String address = String.join(".", nums);
                    ans.add(address);
                }
                return;
            }

            // special case: leading 0 check
            if (s.charAt(idx) == '0') {
                nums.add("0");
                // take 0 and move to the next number in an IP address
                generate(s, idx + 1, nums, ans);
                nums.remove(nums.size() - 1); // backtrack
                return;
            }

            // need at most 3 digits for a number in 0 - 255 range
            for (int i = 0; i < 3; i++) {
                if (idx + i < n) {
                    String num = s.substring(idx, idx + i + 1);
                    int x = Integer.parseInt(num);
                    if (x >= 0 && x <= 255) {
                        nums.add(num);
                        generate(s, idx + i + 1, nums, ans);
                        nums.remove(nums.size() - 1); // backtrack
                    }
                }
            }
        }
    }
}
