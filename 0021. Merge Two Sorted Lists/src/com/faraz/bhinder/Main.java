package com.faraz.bhinder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        Solution s = new Solution();
        s.mergeTwoLists(list1, list2);
    }
}


// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        }

        ListNode head1 = list1;
        ListNode head2 = list2;
        List<ListNode> listNodes = new ArrayList<>();

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                listNodes.add(head1);
                head1 = head1.next;
            } else {
                listNodes.add(head2);
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            while (head1 != null) {
                listNodes.add(head1);
                head1 = head1.next;
            }

        } else if (head2 != null) {
            while (head2 != null) {
                listNodes.add(head2);
                head2 = head2.next;
            }
        }
        for (int i = 0; i < listNodes.size()-1; i++) {
            listNodes.get(i).next = listNodes.get(i+1);
        }
        return listNodes.get(0);
    }
}