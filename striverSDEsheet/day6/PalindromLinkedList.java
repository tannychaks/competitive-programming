package striverSDEsheet.day6;

public class PalindromLinkedList {
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

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);

        PalindromLinkedList list = new PalindromLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);
        System.out.println("\n************************");
        System.out.println("| Is linked list Palindrome? |");
        System.out.println("************************");
        System.out.println(list.isPalindrome(head));
    }

    private boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // mid element of linked list
        ListNode slow = midElementlinkedList(head);

        slow.next = reverse(slow.next);

        slow = slow.next;
        ListNode dummy = head;

        while (slow != null) {
            if (dummy.val != slow.val)
                return false;
            slow = slow.next;
            dummy = dummy.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    private ListNode midElementlinkedList(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
}
