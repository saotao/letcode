package letcode.answer21_30;

import java.util.*;

/*合并n个有序ListNode*/
public class MergekSortedLists23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        List<ListNode> listNodes = new ArrayList<>();

        for(ListNode lists1 : lists){
            while (lists1!=null){
                listNodes.add(lists1);
                lists1 = lists1.next;
            }
        }
        Collections.sort(listNodes, Comparator.comparingInt(o -> o.val));

        for(int i=0;i<listNodes.size()-1;i++){
            listNodes.get(i).next = listNodes.get(i+1);
        }
        if(listNodes.size()==0) return null;
        return listNodes.get(0);
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

    public ListNode mergeKLists2(ListNode[] lists) {

        if(lists==null||lists.length==0){
            return null;
        }
        ListNode listNode = new ListNode(-1);
        for(int i=0;i<lists.length-1;i++){
            listNode = mergeTwoListsDG(lists[i],lists[i+1]);
        }
        if(listNode.val==-1) return null;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        ListNode listNode24 = new ListNode(5);
        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(4);
        ListNode listNode33 = new ListNode(6);
        ListNode listNode34 = new ListNode(7);

        listNode11.next = listNode12;
        listNode12.next=listNode13;
        listNode21.next=listNode22;
        listNode22.next=listNode23;
        listNode23.next=listNode24;
        listNode31.next=listNode32;
        listNode32.next=listNode33;
        listNode33.next=listNode34;
        ListNode[] listNodes = new ListNode[]{listNode11,listNode21,listNode31};
        ListNode listNode = new MergekSortedLists23().mergeKLists(listNodes);
        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }

    }

}
