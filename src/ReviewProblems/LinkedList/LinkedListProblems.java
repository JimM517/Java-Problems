package ReviewProblems.LinkedList;

public class LinkedListProblems {



    /*** linked list problems from leet code 150 ***/

    private static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
            next = null;
        }
    }





    // 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }


        }

        return false;


    }






    // 21. Merge two sorted lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;


        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
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










}
