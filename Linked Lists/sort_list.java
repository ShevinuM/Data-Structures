/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * 
 * Example 1:
 *  Input: head = [4,2,1,3]
 *  Output: [1,2,3,4]
 * 
 * Example 2:
 *  Input: head = [-1,5,3,4,0]
 *  Output: [-1,0,3,4,5]
 * 
 * Example 3:
 *  Input: head = []
 *  Output: []
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * For this problem I'm using merge sort. First I split the list to two parts. Then I sort each part and finally merge the two parts. It involves a
     * series of recursive calls to achieve this.
     */
    public ListNode sortList(ListNode head) {
        ListNode temp, right, left;
        if (head == null || head.next == null) {
            return head;
        }
        temp = splitList(head);
        right = temp.next;
        temp.next = null;
        left = head;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    public ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (left != null && right != null){
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) { tail.next = left; }
        if (right != null) { tail.next = right; }
        return head.next;
    }
}