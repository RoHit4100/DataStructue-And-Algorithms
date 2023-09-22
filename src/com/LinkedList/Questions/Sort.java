package com.LinkedList.Questions;

class LLQ{
    ListNode head;
    ListNode tail;
    int size = 0;
    public void display() {
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
        size++;
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
        size++;
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
        ListNode midPrev = null;  // initialize midPrev as slow pointer this pointer will remain always behind the mid.
        // when head reaches to its end then break the loop
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;  // check if midPrev is null or not, if null then assign head to it.
                                            // if midPrev is not null then move midPrev by 1 node ahead,
            head = head.next.next;  // move head 2 nodes ahead.
        }
        assert midPrev != null; // we believe that midPrev is not null after traversing through whole list.
        ListNode mid = midPrev.next; // now create new middle node, assign the midPrev next node to it.
        midPrev.next = null; // now disconnect the midPrev node from its LL.
        return mid;
    }


    // bubble sort.
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        // edge condition for recursive loop
        if (row == 0) {
            return;
        }

        /*
            To perform bubble sort using recursion we consider each iteration as row, so the edge condition will be row == 0 then break.
            in each iteration we will just increment our column by 1.
            until we reach our row, which is initially going to be length - 1;
         */
        if (col < row) {
            // take first node pointer
            ListNode first = get(col);
            // check whether the second node of the first pointer node is null or not.
            if (first.next == null) {
                // if that next element of the first is null then that means we are at on tail node. so return form that node.
                return;
            }
            // take second pointer as next node of the first pointer node.
            ListNode second = first.next;

            // check whether the first node's value is greater than second node's value
            if (first.val > second.val) {
                // if first node has greater value then swap both of those node.
                // there will be three cases to swap.

                // first when we are going to be at head.
                if (first == head) {
                    // then make second node as head.
                    head = second;
                    // update first node's next with second node's next
                    first.next = second.next;
                    // now update second node's next as first node.
                    second.next = first;
                } else if (second == tail) { // there will be another case when we have to swap tail element with its previous element.
                    // to swap we will require the previous element of the node which we are at now.
                    // and that prev node will be present at current node - 1 location.
                    ListNode prev = get(col - 1);
                    // assign that previous node's next as the second node.
                    prev.next = second;
                    // update the tail as first.
                    tail = first;
                    // make tail's next node as null.
                    tail.next = null;
                    // update the second node's next as the new tail.
                    second.next = tail;
                } else { // now there will another swap condition when we are present at the middle of the list.
                    // in this case also we require current node's previous node.
                    ListNode prev = get(col - 1);
                    // make prev node's next node as second.
                    prev.next = second;
                    // update first.next as second.next
                    first.next = second.next;
                    // update second.next as first.
                    second.next = first;
                }
            }
            // after swapping or without even swapping we have to move ahead by one at each time.
            bubbleSort(row, col + 1);
        } else {
            // after completing each iteration now we have to move decrement the row by 1. as bubble sort check n - 1 times.
            bubbleSort(row - 1, 0);
        }
    }

    private ListNode get(int index) {
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public static class ListNode {
      private int val;
      private ListNode next;
      private ListNode() {}
      private ListNode(int val) { this.val = val; }
      private ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
public class Sort {
    public static void main(String[] args) {
        // merge two sorted list
        LLQ first = new LLQ();
        first.insertLast(77);
        first.insertLast(2);
        first.insertLast(33);
        first.display();

        LLQ second = new LLQ();
        second.insertFirst(223);
        second.insertFirst(3);
        second.insertFirst(1777);
        second.insertFirst(19);
        second.display();

        second.bubbleSort();
        second.display();
    }
}
