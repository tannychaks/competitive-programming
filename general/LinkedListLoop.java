package general;

public class LinkedListLoop {

  /* Linked list Node */
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  Node head;// head of list
  /* Inserts a new Node at front of the list. */

  public void push(int new_data) {
    /*
     * 1 & 2: Allocate the Node & Put in the data
     */
    Node new_node = new Node(new_data);

    /* 3. Make next of new Node as head */
    new_node.next = head;

    /* 4. Move the head to point to new Node */
    head = new_node;
  }

  public static void main(String[] args) {
    LinkedListLoop linkedList = new LinkedListLoop();
    linkedList.push(1);
    linkedList.push(2);
    linkedList.push(3);
    linkedList.push(4);

    /* Create loop for testing */
    linkedList.head.next.next.next.next = linkedList.head;
    if (hasCycle(linkedList.head))
      System.out.println("loop detected");
    else
      System.out.println("No loop detected");
  }

  /** Floyd's Cycle algorithm to dtect loop/cycle */
  private static boolean hasCycle(Node head) {
    if (head == null)
      return false;
    Node slow, fast;
    slow = head;
    fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        break;
    }
    return slow == fast;

  }
}
