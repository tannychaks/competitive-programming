package striverSDEsheet.day7;

public class RotateLinkedList {
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

        RotateLinkedList list = new RotateLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);

        head = rotateRight(head, 2);
        System.out.println("\n************************");
        System.out.println("| Rotated List Toward right |");
        System.out.println("************************");
        list.printList(head);
    }

    private static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int len = 1;

        while (temp.next != null) {
            ++len;
            temp = temp.next;
        }

        temp.next = head;

        k %= len;

        int end = len - k;

        while (end-- > 0)
            temp = temp.next;

        head = temp.next;
        temp.next = null;

        return head;
    }
}
