package striverSDEsheet.day6;

import java.util.HashSet;
import java.util.Set;

public class Intersection2linkedList {

    /**
     * Definition of single linked list
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private void printList(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.val);
                break;
            }
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);

        Intersection2linkedList list = new Intersection2linkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(headA);
        list.printList(headB);

        ListNode node = getIntersectionNodeoptimised(headA, headB);
        System.out.println("**************************");
        System.out.println("| Intersected Linked List|");
        System.out.println("**************************");
        list.printList(node);

    }

    /**
     * Time Complexity: O(2*max(length of list1,length of list2))
     * 
     * Reason: Uses the same concept of difference of lengths of two lists.
     * 
     * Space Complexity: O(1)
     * 
     * Reason: No extra data structure is used
     * 
     * 
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNodeoptimised(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;

        while (d1 != d2) {
            d1 = d1 == null ? headB : d1.next;
            d2 = d2 == null ? headA : d2.next;
        }
        return d1;
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }

        return headB;
    }

}
