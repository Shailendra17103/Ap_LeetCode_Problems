package Ap_LeetCode_Problems.AP_1;

public class Delete_the_Middle_Node_of_a_Linked_List {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        ListNode prev = new ListNode(0); // Dummy node to handle edge cases
        prev.next = head;
        ListNode slow = prev; // Slow pointer (will point to the node before the middle)
        ListNode fast = head; // Fast pointer

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        slow.next = slow.next.next;

        return prev.next; // Return the modified list
    }
}