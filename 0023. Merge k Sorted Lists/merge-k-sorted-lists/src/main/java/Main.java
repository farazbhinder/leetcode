public class Main {
    public static void main(String[] args) {
        // [[1,4,5],[1,3,4],[2,6]]
        ListNode list1a = new ListNode(1);
        ListNode list1b = new ListNode(4);
        ListNode list1c = new ListNode(5);
        list1a.next = list1b;
        list1b.next = list1c;

        ListNode list2a = new ListNode(1);
        ListNode list2b = new ListNode(3);
        ListNode list2c = new ListNode(4);
        list2a.next = list2b;
        list2b.next = list2c;

        ListNode list3a = new ListNode(2);
        ListNode list3b = new ListNode(6);
        list3a.next = list3b;

        ListNode[] listNodes = new ListNode[] {list1a, list2a, list3a};
        Solution s = new Solution();
        s.mergeKLists(listNodes);

        // [[]]
        s.mergeKLists(new ListNode[] {null});

    }
}
