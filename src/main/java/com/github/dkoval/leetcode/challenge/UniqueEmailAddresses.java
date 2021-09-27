package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3989/">Unique Email Addresses</a>
 * <p>
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters,
 * the email may contain one or more '.' or '+'.
 * <p>
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be
 * forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 * <p>
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 * <p>
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given an array of strings emails where we send one email to each email[i], return the number of different addresses that actually receive mails.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= emails.length <= 100</li>
 *  <li>1 <= emails[i].length <= 100</li>
 *  <li>email[i] consist of lowercase English letters, '+', '.' and '@'</li>
 *  <li>Each emails[i] contains exactly one '@' character</li>
 *  <li>All local and domain names are non-empty</li>
 *  <li>Local names do not start with a '+' character</li>
 * </ul>
 */
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = normalize(parts[0]);
            String domain = parts[1];
            unique.add(local + "@" + domain);
        }
        return unique.size();
    }

    private String normalize(String local) {
        int plusIdx = local.indexOf('+');
        if (plusIdx != -1) {
            local = local.substring(0, plusIdx);
        }
        return local.replace(".", "");
    }
}
