package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/">Delete Nodes From Linked List Present in Array</a>
 * <p>
 * You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list
 * after removing all nodes from the linked list that have a value that exists in nums.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 *  <li>All elements in nums are unique.</li>
 *  <li>The number of nodes in the given list is in the range [1, 10^5].</li>
 *  <li>1 <= Node.val <= 10^5</li>
 *  <li>The input is generated such that there is at least one node in the linked list that has a value not present in nums.</li>
 * </ul>
 */
public interface DeleteNodesFromLinkedListPresentInArray {

    ListNode modifiedList(int[] nums, ListNode head);

    class DeleteNodesFromLinkedListPresentInArrayRev1 implements DeleteNodesFromLinkedListPresentInArray {

        @Override
        public ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> uniq = new HashSet<>();
            for (int x : nums) {
                uniq.add(x);
            }

            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                if (uniq.contains(curr.val)) {
                    // remove current node
                    if (prev != null) {
                        prev.next = next;
                    } else {
                        head = next;
                    }
                } else {
                    prev = curr;
                }
                curr = next;
            }
            return head;
        }
    }
}
