package com.LinkedList.Questions;

import java.util.List;

class LLQ extends LL{
    ListNode head;
    ListNode tail;
    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
    public void insertFirst(int value) {
        // first we create a new node
        ListNode newNode = new ListNode(value);
        // assign the current head of the link list to newNodes next, therefore current head will become the next node of the linked list
        newNode.next = head;
        // now update the head's value, assign head to newNode.
        head = newNode;
        // if it is first element means when tail is null, then assign head and tail to same element
        if (tail == null) {
            tail = head;
        }
    }

    public void insertLast(int value){
        // first create the new node with given value
        ListNode node = new ListNode(value);
        // check whether the tail is null or not, means whether list is empty or not
        if (tail == null) {
            // if empty then call the insertFirst method
            insertFirst(value);
            // return after creating new node
            return;
        }
        // assign the next node of with the new created node.
        tail.next = node;
        // update the tail with newly created node.
        tail = node;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,  right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        // store head of the ans list to return at the end
        ListNode ansHead = new ListNode();
        // now make head and tail same, because empty LL has head and tail at the same point
        ListNode tail = ansHead;
        // run till any of the head becomes null
        while (list1 != null && list2 != null) {
            // check whether value of first head is less than another head.
            if (list2.val > list1.val) {
                // in these case list1 has the lesser value than list2
                // therefore make tail.next to list1
                // to add any node to list we have to fix head location and add those nodes with the help of the tail
                tail.next = list1;
                // now move list1 head to ahead by making list1 = list.next
                list1 = list1.next;
                // now move tail ahead also.
                tail = tail.next;
            }else{
                // do the same as previous case for list2
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        // check which list had been reach to its end
        // add another list's remaining node to the newly created LL
        // by assigning the current head location of that list to our tail.next
        if (list1 != null) {
            tail.next = list1;
        }else{
            tail.next = list2;
        }
        // in the end just return the new LL second node.
        return ansHead.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static class ListNode {
      private int val;
      private ListNode next;
      private ListNode() {}
      private ListNode(int val) { this.val = val; }
      private ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
public class MergeSort {
    public static void main(String[] args) {
        // merge two sorted list
        LLQ first = new LLQ();
        first.insertLast(77);
        first.insertLast(2);
        first.insertLast(33);
        first.display();

        LLQ second = new LLQ();
        second.insertLast(223);
        second.insertLast(3);
        second.insertLast(1777);
        second.insertLast(19);
        second.display();

    }
}
