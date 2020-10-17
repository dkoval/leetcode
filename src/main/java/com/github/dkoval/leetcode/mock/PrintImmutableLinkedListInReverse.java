package com.github.dkoval.leetcode.mock;

import com.github.dkoval.leetcode.ImmutableListNode;

/**
 * <a href="https://leetcode.com/problems/print-immutable-linked-list-in-reverse/">Print Immutable Linked List in Reverse</a>
 *
 * You are given an immutable linked list, print out all values of each node in reverse with the help of the
 * following interface:
 *
 * ImmutableListNode: An interface of immutable linked list, you are given the head of the list.
 * You need to use the following functions to access the linked list (you can't access the ImmutableListNode directly):
 *
 * ImmutableListNode.printValue(): Print value of the current node.
 * ImmutableListNode.getNext(): Return the next node.
 *
 * The input is only given to initialize the linked list internally.
 * You must solve this problem without modifying the linked list.
 * In other words, you must operate the linked list using only the mentioned APIs.
 */
public class PrintImmutableLinkedListInReverse {

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
