// submitted on Nov 11, 2017

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            ListNode i = l1;
            ListNode j = l2;

            ListNode l3 = new ListNode(-1);

            ListNode k = l3;

            int carry = 0;

            int sum = 0;
            while (i != null && j != null)
            {
                sum = i.val + j.val + carry;
                
                int digit = sum;
                if (sum >= 10)
                {
                    digit = sum - 10;
                    carry = 1;
                }
                else
                {
                    carry = 0;
                }

                k.val = digit;
                i = i.next;
                j = j.next;
                if (i == null && j == null)
                {
                    continue;
                }
                k.next = new ListNode(-1);
                k = k.next;

            }

            if (i == null)
            {
                while (j != null)
                {
                    sum = j.val + carry;

                    int digit = sum;
                    if (sum >= 10)
                    {
                        digit = sum - 10;
                        carry = 1;
                    }
                    else
                    {
                        carry = 0;
                    }

                    k.val = digit;
                    j = j.next;
                    if (j != null)
                    {
                        k.next = new ListNode(0);
                        k = k.next;
                    }
                }
            }
            else if (j == null)
            {
                while (i != null)
                {
                    sum = i.val + carry;

                    int digit = sum;
                    if (sum >= 10)
                    {
                        digit = sum - 10;
                        carry = 1;
                    }
                    else
                    {
                        carry = 0;
                    }

                    k.val = digit;
                    i = i.next;
                    if (i != null)
                    {
                        k.next = new ListNode(0);
                        k = k.next;
                    }
                }
            }
            if (carry == 1)
            {
                k.next = new ListNode(1);
            }
            else
            {
                k = null;
            }

            return l3;
        }
}