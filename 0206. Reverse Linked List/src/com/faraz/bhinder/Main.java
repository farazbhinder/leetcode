package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        Solution s = new Solution();
        s.reverseList(list);
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode firstPtr = head;
        ListNode secondPtr = head.next;
        while (secondPtr != null) {
            firstPtr.next = newHead;
            newHead = firstPtr;
            firstPtr = secondPtr;
            secondPtr = secondPtr.next;
        }
        firstPtr.next = newHead;
        newHead = firstPtr;
        return newHead;
    }
}
