package striverSDEsheet.day14;

import java.util.Stack;

public class MinStackDriver {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());// return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2

        MinStackOptimized minStackOpt = new MinStackOptimized();
        minStackOpt.push(-2);
        minStackOpt.push(0);
        minStackOpt.push(-3);
        System.out.println(minStackOpt.getMin());// return -3
        minStackOpt.pop();
        System.out.println(minStackOpt.top()); // return 0
        System.out.println(minStackOpt.getMin()); // return -2
    }
}

class MinStackOptimized {
    private ListNode node;

    public MinStackOptimized() {
        node = null;
    }

    public void push(int val) {
        ListNode curr = new ListNode();
        curr.val = val;
        if (node == null)
            curr.minVal = val;
        else {
            curr.minVal = Math.min(node.minVal, val);
            curr.next = node;
        }

        node = curr;

    }

    public void pop() {
        node = node.next;

    }

    public int top() {
        return node.val;

    }

    public int getMin() {
        return node.minVal;

    }
}

class ListNode {
    public int val;
    public int minVal;
    public ListNode next;
}

class MinStack {
    Stack<Long> st = new Stack<>();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if (st.isEmpty()) {
            mini = value;
            st.push(value);
        } else {
            if (value < mini) {
                st.push(2 * value - mini);
                mini = value;
            } else
                st.push(value);
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;

        Long val = st.pop();
        if (val < mini)
            mini = 2 * mini - val;
    }

    public int top() {
        Long val = st.peek();
        if (val < mini)
            return mini.intValue();
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}