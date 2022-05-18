package striverSDEsheet.day7;

public class CloneRandomLinkedList {
    /**
     * Definition of single linked list
     */
    static class Node {
        int val;
        Node next, random;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    private void printList(Node head) {
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.val + " ( Random : " + head.random.val + " ) ");
                break;
            }
            System.out.print(head.val + " ( Random : " + head.random.val + " ) " + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // 1's random points to 3
        head.random = head.next.next;

        // 2's random points to 1
        head.next.random = head;

        // 3's and 4's random points to 5
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;

        // 5's random points to 2
        head.next.next.next.next.random = head.next;

        CloneRandomLinkedList list = new CloneRandomLinkedList();
        System.out.println("********************");
        System.out.println("| Given Linked list |");
        System.out.println("********************");
        list.printList(head);

        head = copyRandomList(head);

        System.out.println("********************");
        System.out.println("| Deep copied Linked list |");
        System.out.println("********************");
        list.printList(head);

    }

    private static Node copyRandomList(Node head) {

        Node iter = head, front = head;
        Node copy = head;
        // Making Deep Copy Nodes
        while (iter != null) {
            front = iter.next;
            copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        iter = head;
        // Mapping original with deep copies
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Getting original linked list with aid of deep copy
        iter = head;
        Node dummy = new Node(0);
        copy = dummy;

        while (iter != null) {
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }

        return dummy.next;
    }
}
