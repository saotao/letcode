package answer11_20;

/*移除列表倒数第n位的节点*/
public class RemoveNthNodeFromEndofList_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null||n<=0) return head;
        if(head.next == null) return null;
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode fir = root.next;
        for(int i=0;i<n;i++){
            fir = fir.next;
        }
        if(fir == null){
            return head.next;
        }
        ListNode sec = root.next;
        while (fir.next!=null){
            fir = fir.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd8s(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//
//        removeNthFromEnd(listNode,2);
        removeNthFromEnd8s(listNode3,2);

    }
}
