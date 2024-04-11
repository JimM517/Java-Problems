package LeetCodeOneFifty.LinkedList;

public class LinkedListProblems {



    /*** linked list problems from leet code 150 ***/

    private static class ListNode {
        int val;
        ListNode next;

//        ListNode (int x) {
//            val = x;
//            next = null;
//        }

        ListNode() {};

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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









    // 61. rotate list
    public ListNode rotateRight(ListNode head, int k) {


        if (head == null || head.next == null || k == 0) {
            return head;
        }



        ListNode tail = head;

        int size = 1;


        while (tail.next != null) {
            size++;
            tail = tail.next;
        }



        int rotationCount = k % size;
        tail.next = head;


        for (int i = 0; i < size - rotationCount; i++) {
            tail = tail.next;
        }


        head = tail.next;
        tail.next = null;

        return head;


    }









}
