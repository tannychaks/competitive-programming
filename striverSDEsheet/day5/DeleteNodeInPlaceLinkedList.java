package striverSDEsheet.day5;

public class DeleteNodeInPlaceLinkedList {
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

        DeleteNodeInPlaceLinkedList list = new DeleteNodeInPlaceLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);

        ListNode node = getNode(head, 2);
        deleteNode(node);
        System.out.println("********************");
        System.out.println("| New Linked list After Delete |");
        System.out.println("********************");
        list.printList(head);

    }

    private static void deleteNode(ListNode node) {
        if (node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static ListNode getNode(ListNode head, int val) {
        if (head == null)
            return null;
        while (head.val != val)
            head = head.next;

        return head;
    }
}
