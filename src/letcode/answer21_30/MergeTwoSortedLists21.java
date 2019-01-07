package letcode.answer21_30;

/*合并两个列表*/
public class MergeTwoSortedLists21 {

    //插入很烦，新建了

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode root = new ListNode(-1);
        ListNode next= new ListNode(-1);
        root.next = next;

        while (l1!=null&&l2!=null) {

            if (l1.val < l2.val) {
                next.next =new ListNode(l1.val);
                l1 = l1.next;
            }else {
                next.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            next = next.next;
        }
        if(l1==null&&l2!=null) next.next = l2;
        else next.next = l1;

        return root.next.next;
    }

    //巨老递归
    public ListNode mergeTwoListsDG(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsDG(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsDG(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        ListNode listNode24 = new ListNode(5);

        listNode11.next = listNode12;
        listNode21.next = listNode22;
        listNode11.next.next=listNode13;
        listNode21.next.next=listNode23;
        listNode21.next.next.next=listNode24;
        new MergeTwoSortedLists21().mergeTwoLists(listNode11,listNode21);
    }
}
