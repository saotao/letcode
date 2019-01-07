package letcode.answer21_30;

import java.util.ArrayList;
import java.util.List;

/*分组反转，分成k组，进行反转，不够k的，原封不变*/
public class ReverseNodesinkGroup25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) return head;

        ListNode listNode = new ListNode(-1);
        List<ListNode> listNodes = new ArrayList<>();
        listNode.next = head;
        ListNode listNode1 = listNode.next;
        while (listNode1 != null) {
            listNodes.add(listNode1);
            listNode1 = listNode1.next;
        }
        if (listNodes.size() < k) return head;
        ListNode tem = new ListNode(-1);
        listNode.next = tem;
        int i = 0, j = k - 1;
        while (j < listNodes.size()) {
            tem.next = listNodes.get(j);
            tem = listNodes.get(j);
            if (j > i) {
                j--;
            } else {
                i += k;
                j = i + k - 1;
            }
        }
        if (i < listNodes.size()) {
            tem.next = listNodes.get(i);
        }else {
            tem.next = null;
        }

        return listNode.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode21 = new ListNode(6);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        ListNode listNode24 = new ListNode(5);

        listNode11.next = listNode12;
        listNode11.next.next = listNode13;
        listNode11.next.next.next = listNode21;
        listNode11.next.next.next.next = listNode22;
        listNode11.next.next.next.next.next = listNode23;
        listNode11.next.next.next.next.next.next = listNode24;

        ListNode listNode = new ReverseNodesinkGroup25().reverseKGroup(listNode11, 3);
        while (listNode != null) {
            if (listNode.next != null)
                System.out.print(listNode.val + ",");
            else
                System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

}
