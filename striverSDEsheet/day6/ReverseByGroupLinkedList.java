package striverSDEsheet.day6;

public class ReverseByGroupLinkedList {
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

        ReverseByGroupLinkedList list = new ReverseByGroupLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);
        head = list.reverseKGroup(head, 3);
        System.out.println("\n************************");
        System.out.println("| Reversed linked list |");
        System.out.println("************************");
        list.printList(head);
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);

        int len = getLength(head);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr, nex;

        while (len >= k) {
            curr = pre.next;
            nex = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;

            len -= k;
        }
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
