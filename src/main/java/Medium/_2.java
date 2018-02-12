package Medium;

import java.util.List;
import java.util.Stack;

public class _2 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode ln = res;
        int prev = 0;
        while (l1 != null && l2 != null) {
            ln.next = new ListNode((l1.val + l2.val + prev) % 10);
            prev = (l1.val + l2.val + prev) / 10;
            ln = ln.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                ln.next = new ListNode((prev + l1.val) % 10);
                prev = (l1.val + prev) / 10;
                ln = ln.next;
                l1 = l1.next;
                if (prev == 0) {
                    ln.next = l1;
                    break;
                }
            }
            if (prev != 0) {
                ln.next = new ListNode(prev);
            }
        } else if (l2 != null) {
            while (l2 != null) {
                ln.next = new ListNode((prev + l2.val) % 10);
                prev = (l2.val + prev) / 10;
                ln = ln.next;
                l1 = l2.next;
                if (prev == 0) {
                    ln.next = l2;
                    break;
                }
            }
            if (prev != 0) {
                ln.next = new ListNode(prev);
            }
        } else if (prev != 0) {
            ln.next = new ListNode(prev);
        }
        return res.next;
    }

    public static void main(String[] args) {
        _2 test = new _2();
        
    }
}
