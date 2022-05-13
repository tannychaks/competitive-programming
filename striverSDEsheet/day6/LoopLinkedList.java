package striverSDEsheet.day6;

public class LoopLinkedList {
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
        int count = 0;
        while (head != null) {
            if (head.val == 1) {
                count++;
                if (count == 3) {
                    System.out.println(head.val);
                    break;
                }
            }
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
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = head;

        LoopLinkedList list = new LoopLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);

        ListNode node = detectCycle(head);
        System.out.println("**************************");
        System.out.println("|Has Cycle? |");
        System.out.println("**************************");
        list.printList(node);

    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = head;
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }

                return entry;
            }
        }

        return null;
    }
}
