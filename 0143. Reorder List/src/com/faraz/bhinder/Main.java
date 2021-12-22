package com.faraz.bhinder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution s = new Solution();
        s.reorderList(node);
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
    Queue<ListNode> queue = new ArrayDeque<>();
    Stack<ListNode> stack = new Stack<>();
    List<ListNode> list = new ArrayList<>();

    public void reorderList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            queue.add(curr);
            stack.push(curr);
            curr = curr.next;
        }

        int count = stack.size();
        while (queue.size() > 0 && stack.size() > 0) {
            list.add(queue.remove());
            list.add(stack.pop());

        }
        for (int i = 0; i < count; i++) {
            list.get(i).next = list.get(i+1);
        }
        list.get(count).next = null;
        queue.clear();
        stack.clear();
        list.clear();
    }
}