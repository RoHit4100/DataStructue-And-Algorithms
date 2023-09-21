package com.LinkedList.Questions;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    LL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        // first we create a new node
        Node newNode = new Node(value);
        // assign the current head of the link list to newNodes next, therefore current head will become the next node of the linked list
        newNode.next = head;
        // now update the head's value, assign head to newNode.
        head = newNode;
        // if it is first element means when tail is null, then assign head and tail to same element
        if (tail == null) {
            tail = head;
        }
        // increase the size of the link list by 1;
        size += 1;
    }

    public void insertLast(int value){
        // first create the new node with given value
        Node node = new Node(value);
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
        // increase the size by 1
        size += 1;
    }

    public void insertWithRec(int index, int value) {
        // call the insertRec function with head and given para.
        head = insertRec(index, value, head);
    }

    private Node insertRec(int index, int value, Node current) {
        // check till index becomes 0
        if (index == 0) {
            // then create a temp node which will consist of the given value.
            // the next of the newly created node will be the previous node's next which is pass given to function call
            Node temp = new Node(value, current);
            // after creating increment the size of the LL by one
            size++;
            // In the end just return temp node.
            return temp;
        }

        // store the return node as current.next node.
        // e.g. 7 8 9
        // in the function, if we are at 7, then we will pass the next node of the 7 which is 8.
        // so when another node is added at the place of 8
        // then next node of the 7 will become that return node.
        // as at every call this func is returning itself.

        // decrement the index size at every call and pass current.next node in every call
        current.next = insertRec(index - 1  , value, current.next);
        // in the end head will be returned.
        return current;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    // Questions

    // remove duplicates from sorted LL
    public void removeDup() {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.value == temp.value) {
                temp.next = temp.next.next;
                size--;
            }else{
                temp = temp.next;
            }
        }
        tail = temp;
    }

    // Leet code submission ans
    private Node deleteDuplicates(Node head) {
        // check whether the list is empty or not
        if(head == null){
            // return null
            return null;
        }
        // create new temporary node which will point location as head variable.
        Node node = head;
        // run this loop until current node's next element became null
        while (node.next != null) {
            // check whether the current node's value == next node's value.
            if (node.value == node.next.value) {
                // if next node's value is same then modify the current node's next and assign as next node's next.
                node.next = node.next.next;
            }else {
                // if value is not same the make that node current node, and do the same process.
                node = node.next;
            }
        }
        // on leetcode always return the head, because it signifies most.
        return head;
    }


    // merge two lists
    // method will return LL taking 2 LL as arguments.
    // this method will be static as any static function can access this without creating object.
    public static LL mergeList(LL firstListHead, LL secondListHead) {
        // create first temp node to traverse through first LL
        // assign first LL head as first.
        Node first = firstListHead.head;
        // assign second LL head as second
        Node second = secondListHead.head;

        // create new LL which will contain our answer or merge LL
        LL newList = new LL();
        // traverse the both LL till any of the LL node reaches at null
        while (first != null && second != null) {
            // check whether the first's node and second's nodes value is greater than the another node's value
            if (first.value > second.value) {
                // if second node has the lesser value then add that element into the new LL
                newList.insertLast(second.value);
                // and move the pointer of the second LL on next node
                second = second.next;
            } else {
                // do the same as previous stage for other condition
                newList.insertLast(first.value);
                first = first.next;
            }
        }

        // now after reaching at the end of any LL, check other link list till its end
        // add all the remaining element of that list into the new LL

        // only one of these two loops will run, as one of those LL are reach at its null.
        while (first != null) {
            newList.insertLast(first.value);
            first = first.next;
        }
        while (second != null) {
            newList.insertLast(second.value);
            second = second.next;
        }
        // at the end just return the new LL.
        return newList;
    }

    // leetcode solution for merge two sorted list
    private Node mergeTwoLists(Node list1, Node list2) {
        // store head of the ans list to return at the end
        Node ansHead = new Node();
        // now make head and tail same, because empty LL has head and tail at the same point
        Node tail = ansHead;
        // run till any of the head becomes null
        while (list1 != null && list2 != null) {
            // check whether value of first head is less than another head.
            if (list2.value > list1.value) {
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


    // linked list cycle present or not.(fast and slow pointer method)
    // leetcode solution.
    private boolean hasCycle(Node head) {
        // take two pointer fast and slow
        // at start they both will point at the head
        Node slow = head;
        Node fast = head;
        // travers till fast && fast.next != null, if any of the current value becomes null then break the loop
        while (fast != null && fast.next != null) {
            // now move by 1 node
            slow = slow.next;
            // move fast by 2 node
            fast = fast.next.next;
            // check whether fast and slow are at same node or not.
            if (fast == slow)
                // if they are same node then return true, means cycle is present
                return true;
        }
        // if null is encountered by fast or fast.next means cycle is not present then return false.
        return false;
    }


    // length of the cycle.
    private int lengthOfCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // after we found out that cycle is present in the LL.
                // now initiate a counter variable to count the length.
                int counter = 0;
                // initially slow and fast are same, so we want to run this loop at-least once.
                // therefore we will use do while loop.
                do{
                    // move slow node to next node.
                    slow = slow.next;
                    // increase the counter by 1;
                    counter++;
                }while (slow != fast);    // run this loop till slow again == fast.
                // return the counter.
                return counter;
            }
        }
        return 0;
    }
    private static class Node{
        private final int value;
        private Node next;

        private Node() {
            this.value = 0;
        }
        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}