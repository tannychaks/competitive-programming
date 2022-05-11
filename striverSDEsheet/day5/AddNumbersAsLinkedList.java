package striverSDEsheet.day5;

public class AddNumbersAsLinkedList {
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
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(7);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(4);

        AddNumbersAsLinkedList list = new AddNumbersAsLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(list1);
        list.printList(list2);

        list1 = addTwoNumbers(list1, list2);
        System.out.println("********************");
        System.out.println("| New Linked list |");
        System.out.println("********************");
        list.printList(list1);

    }

    private static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        int carry = 0;
        while (list1 != null || list2 != null || carry != 0) {
            int sum = 0;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            sum += carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
