package striverSDEsheet.day5;

public class MergeSortedLinkedList {
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

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(7);
        list1.next.next = new ListNode(10);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(10);

        MergeSortedLinkedList list = new MergeSortedLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(list1);
        list.printList(list2);
        list1 = mergeTwoListsOptimal(list1, list2);
        System.out.println("********************");
        System.out.println("| Merged Linked list |");
        System.out.println("********************");
        list.printList(list1);

    }

    /**
     * TC -> O(m+n) - where m and n are respective lengths of the 2 linked lists
     * SC -> O(m+n) because we have call stacks in heap !
     * 
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoListsOptimal(ListNode list1, ListNode list2) {
        if (list1 == null) // base condition
            return list2;
        if (list2 == null) // base condition
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val)
            return mergeUtil(list1, list2);
        else
            return mergeUtil(list2, list1);

    }

    private static ListNode mergeUtil(ListNode h1, ListNode h2) {
        // if only one node in first list
        // simply point its head to second list
        if (h1.next == null) {
            h1.next = h2;
            return h1;
        }

        // Initialize current and next pointers of
        // both lists
        ListNode curr1 = h1, next1 = h1.next;
        ListNode curr2 = h2, next2 = h2.next;

        while (next1 != null && curr2 != null) {
            // if curr2 lies in between curr1 and next1
            // then do curr1->curr2->next1
            if ((curr2.val) >= (curr1.val) && (curr2.val) <= (next1.val)) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                // now let curr1 and curr2 to point
                // to their immediate next pointers
                curr1 = curr2;
                curr2 = next2;
            } else {
                // if more nodes in first list
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                }

                // else point the last node of first list
                // to the remaining nodes of second list
                else {
                    next1.next = curr2;
                    return h1;
                }
            }
        }
        return h1;
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
}
