/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, 
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end,
 * should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * 
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Use an array list to store each partition
        ArrayList<ListNode[]> partitions = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {

            // store each Node isolated in an array
            ListNode[] partition = new ListNode[k];
            for (int i = 0; i < k; i++) {
                if (curr != null) {
                    partition[i] = curr;
                    ListNode prev = curr;
                    curr = curr.next;
                    prev.next = null;
                }
            }

            partitions.add(partition);
        }

        // Now we have [[1,2], [3,4], [5,null]]
        // Reverse the next pointer in each partition
        for (ListNode[] partition : partitions) {

            // if the last element in partition is null then we are not reversing it
            if (partition[k - 1] == null) {
                for (int i = 0; i < k - 1; i++) {
                    if (partition[i] != null && partition[i + 1] != null)
                        partition[i].next = partition[i + 1];
                }
                continue;
            }

            for (int i = k - 1; i >= 1; i--) {
                partition[i].next = partition[i - 1];
            }

            // we only care about the first and the last for pointers
            ListNode temp = partition[0];
            partition[0] = partition[k - 1];
            partition[k - 1] = temp;
        }

        // connect the partitions together
        for (int i = 0; i < partitions.size() - 1; i++) {
            partitions.get(i)[k - 1].next = partitions.get(i + 1)[0];
        }

        return partitions.get(0)[0];
    }
}
