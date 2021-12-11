package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        int[] arr = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        ListNode listNode = new ListNode(arr[0]);
        ListNode cur = listNode;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        Solution s = new Solution();
        System.out.println(s.hasCycle(listNode));
    }
}


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        if (one == null || one.next == null) {
            return false;
        }
        do {
            if (one.next != null) {
                one = one.next;
            }
            if (two.next != null && two.next.next != null) {
                two = two.next.next;
            }
            if (two == one) {
                return true;
            }
            if (one.next == null || two.next == null || (two.next != null && two.next.next == null)) {
                return false;
            }
        } while (true);
    }
}