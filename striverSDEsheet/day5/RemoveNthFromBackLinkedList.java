package striverSDEsheet.day5;

public class RemoveNthFromBackLinkedList {
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthFromBackLinkedList list = new RemoveNthFromBackLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);

        int n = 2;
        head = removeNthFromEnd(head, n);
        System.out.println("********************");
        System.out.println("| New Linked list |");
        System.out.println("********************");
        list.printList(head);

    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start, fast = start;

        for (int i = 1; i <= n; i++)
            fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

}
