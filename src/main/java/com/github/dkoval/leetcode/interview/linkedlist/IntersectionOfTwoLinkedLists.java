package com.github.dkoval.leetcode.interview.linkedlist;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * Notes:
 * <ul>
 * <li>If the two linked lists have no intersection at all, return null.</li>
 * <li>The linked lists must retain their original structure after the function returns.</li>
 * <li>You may assume there are no cycles anywhere in the entire linked structure.</li>
 * <li>Each value on each linked list is in the range [1, 10^9].</li>
 * <li>Your code should preferably run in O(n) time and use only O(1) memory.</li>
 * </ul>
 */
public abstract class IntersectionOfTwoLinkedLists {

    public abstract ListNode getIntersectionNode(ListNode headA, ListNode headB);

    public static class IntersectionOfTwoLinkedListsByComparingLengths extends IntersectionOfTwoLinkedLists {

        @Override
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = length(headA);
            int lengthB = length(headB);
            int diff = Math.abs(lengthA - lengthB);
            ListNode longer = (lengthA > lengthB) ? headA : headB;
            ListNode shorter = (lengthA > lengthB) ? headB : headA;
            while (diff-- > 0) {
                longer = longer.next;
            }
            while (longer != null) {
                if (longer == shorter) {
                    return longer;
                }
                longer = longer.next;
                shorter = shorter.next;
            }
            return null;
        }

        private int length(ListNode head) {
            int length = 0;
            ListNode curr = head;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            return length;
        }
    }
}
