/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    解题思路
    1.先用两个stack装进去，这样就可以倒序拿到
    2.每次生成一个新的进位的node，往当前head的左边挂，然后head指针左移
    3.最后一次如果没有进位，最左边的那一位会变成0，返回时判断一下即可
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur = new ListNode(0); //全局变量，当前计算位
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = cur.val;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            cur.val = sum % 10;
            ListNode pre = new ListNode(sum / 10); //局部变量，生成新的左侧进位位
            pre.next = cur;
            cur = pre; //index指针左移
        }
        return cur.val == 0 ? cur.next : cur;
    }
}
