import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode current = result;
        PriorityQueue<ListNodePrio> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(new ListNodePrio(lists[i].val, lists[i].next));
        }
        while (!priorityQueue.isEmpty()) {
            ListNodePrio listNodePrio = priorityQueue.remove();
            current.next = new ListNode(listNodePrio.val);
            current = current.next;
            if (listNodePrio.node != null) {
                priorityQueue.add(new ListNodePrio(listNodePrio.node.val, listNodePrio.node.next != null ? listNodePrio.node.next : null));
            }
        }
        result = result.next;
        return result;
    }
}

class ListNodePrio implements Comparable<ListNodePrio> {
    int val;
    ListNode node;

    public ListNodePrio(int val, ListNode listNode) {
        this.val = val;
        this.node = listNode;
    }

    @Override
    public int compareTo(ListNodePrio other) {
        return Integer.compare(this.val, other.val);

    }
}