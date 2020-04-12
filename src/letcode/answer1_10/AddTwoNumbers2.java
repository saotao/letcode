package answer1_10;

/**
 * 列表：l1:2->3->5,l2:4->8->3
 * 相加：6->1->9
 */

public class AddTwoNumbers2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(5);
        ListNode ll1 = new ListNode(3);
        ListNode ll2 = new ListNode(4);
        ListNode ll3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        ll1.next = ll2;
        ll2.next = ll3;
        ListNode answer = addTwoNumbers(l1,ll1);
        while (answer!=null) {
            System.out.println(answer.val);
            answer = answer.next;
        }

    }
}
