package striverSDEsheet.day14;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80)); // return 1
        System.out.println(stockSpanner.next(60)); // return 1
        System.out.println(stockSpanner.next(70)); // return 2
        System.out.println(stockSpanner.next(60)); // return 1
        System.out.println(stockSpanner.next(75)); // return 4, because the last 4 prices (including today's price of
                                                   // 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85)); // return 6
    }
}

class StockSpanner {

    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.peek()[1];
            st.pop();
        }
        st.push(new int[] { price, span });
        return span;
    }
}

class StockSpannerOptimized {
    Stack head;
    int span;

    public StockSpannerOptimized() {
        head = null;
        span = 1;
    }

    public int next(int price) {
        if (head == null) {
            head = new Stack(price, span);
            return head.span;
        }
        Stack s = new Stack(price, 1);
        while (head != null && s.price >= head.price) {
            s.span += head.span;
            head = head.next; // pop()
        }

        s.next = head;
        head = s;
        return head.span;
    }

    class Stack {
        Stack next;
        int price;
        int span;

        public Stack(int price, int span) {
            this.price = price;
            this.span = span;
            next = null;
        }
    }
}