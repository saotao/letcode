package letcode.answer21_30;

import java.util.ArrayList;
import java.util.List;

/*单链表两个节点分为一组进行反转*/
public class SwapNodesinPairs24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if(head == null||head.next==null) return head;

        ListNode listNode = new ListNode(-1);

        List<ListNode> listNodes = new ArrayList<>();

        while (head!=null){
            listNodes.add(head);
            head = head.next;
        }

        int i =0,j=1;
        ListNode tem = new ListNode(-1);
        listNode.next = tem;

        while (j<listNodes.size()){
            tem .next = listNodes.get(j);
            listNodes.get(j).next = listNodes.get(i);
            tem = listNodes.get(i);
            i += 2;
            j += 2;
        }
        if(i<listNodes.size()){
            tem.next = listNodes.get(i);
            tem = listNodes.get(i);
        }
        tem.next = null;
        return listNode.next.next;
    }

    public static void main(String[] args) {
/*        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode21 = new ListNode(6);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        ListNode listNode24 = new ListNode(5);

        listNode11.next=listNode12;
        listNode11.next.next=listNode13;
        listNode11.next.next.next=listNode21;
        listNode11.next.next.next.next=listNode22;
        listNode11.next.next.next.next.next=listNode23;
        listNode11.next.next.next.next.next.next=listNode24;

        ListNode node = new SwapNodesinPairs24().swapPairs(listNode11);
        while (node!=null){
            System.out.print(node.val+" ,");
            node = node.next;
        }*/

        ListNode test = new ListNode(-1);
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(2);
        test.next = test1;
        test1 = test2;
        test1.val = 55;
        System.out.println(test.next.val);
        System.out.println(test1==test.next);
        System.out.println(test1.val==test2.val);
    }
}
