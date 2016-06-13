/**
 * Created by pli on 6/2/16.
 */
public class add_two_numbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int carry = 0;
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;

            while (l1 != null || l2 != null) {

                int a = l1 != null ? l1.val : 0;
                int b = l2 != null ? l2.val : 0;

                int sum = (a + b + carry) % 10;
                carry = (a + b + carry) / 10;

                curr.next = new ListNode(sum);
                curr = curr.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }

            return dummyHead.next;
        }
    }

}
