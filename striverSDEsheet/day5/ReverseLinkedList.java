package striverSDEsheet.day5;

public class ReverseLinkedList {

    // Definition for singly-linked list.
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

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    // prints content of linked list
    void printList(ListNode node) {
        while (node != null) {
            if (node.next == null) {
                System.out.println(node.val);
                break;
            }
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(85);
        head.next = new ListNode(20);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(30);

        ReverseLinkedList list = new ReverseLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);

        head = list.reverseList(head);
        System.out.println("\n************************");
        System.out.println("| Reversed linked list |");
        System.out.println("************************");
        list.printList(head);
    }
}
