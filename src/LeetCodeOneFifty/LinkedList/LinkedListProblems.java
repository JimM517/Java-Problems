package LeetCodeOneFifty.LinkedList;

import java.util.HashMap;
import java.util.Map;

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




    // definition for a node
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
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





    // 2. add two numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode pre = new ListNode(-1);
        ListNode temp = pre;

        while (l1 != null || l2 != null) {


            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;


        }

        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return pre.next;


    }




    // 138. copy list with random pointer
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();


        Node curr = head;

        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }


        curr = head;

        while (curr != null) {

            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }



    // 206. Reverse Linked List
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }







    // 92. Reverse linked list II
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;


        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }



        ListNode curr = prev.next;
        ListNode nextNode;


        for (int i = 0; i < right - left; i++) {
            nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return temp.next;
    }



}
