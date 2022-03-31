package leetCode.linked_list;

/**
 * 141. Linked List Cycle
 * 
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void push(int new_data) {
        /*
         * 1 & 2: Allocate the Node &
         * Put in the data
         */
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String[] args) {

        push(20);
        push(4);
        push(15);
        push(10);

        /* Create loop for testing */
        head.next.next.next.next = head;
        System.out.println(hasCycle(head));

    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}
