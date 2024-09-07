package ListProbs;

import java.util.HashSet;
import java.util.Set;

public class ListNode {

     int val;

    public ListNode next;

    ListNode() {};

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }







    // 21. Merge two sorted lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;


        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 == null ? list2 : list1;

        return dummy.next;

    }



    // 83. remove duplicates from sorted list
    public ListNode deleteDuplicates(ListNode head) {


        ListNode temp = head;

        while (temp != null && temp.next != null) {

            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return head;
    }



    // 2181. merge nodes in between zeros
    public ListNode mergeNodes(ListNode head) {

        ListNode dum = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dum;


        while (head != null && head.next != null) {

            prev.next = head;

            head = head.next;

            while (head != null && head.val != 0) {

                prev.next.val += head.val;

                head = head.next;
            }
            prev = prev.next;
        }
        prev.next = null;

        return dum.next;

    }



    // 3217. Delete nodes from linked list present in array
    public ListNode modifiedList(int[] nums, ListNode head) {



        Set<Integer> numSet = new HashSet<>();

        for (int x : nums) {
            numSet.add(x);
        }

        ListNode result = new ListNode(-1);
        ListNode trv = result;


        while (head != null) {
            if (!numSet.contains(head.val)) {
                trv.next = head;
                trv = trv.next;
            }
            head = head.next;
        }
        trv.next = null;
        return result.next;

    }





























}
