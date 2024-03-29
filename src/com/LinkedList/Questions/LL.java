package com.LinkedList.Questions;

public class LL {
    private ListNode head;
    private ListNode tail;
    private int size;

    LL() {
        this.size = 0;
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
        // increase the size of the link list by 1;
        size += 1;
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
        // increase the size by 1
        size += 1;
    }

    public void insertWithRec(int index, int value) {
        // call the insertRec function with head and given para.
        head = insertRec(index, value, head);
    }

    private ListNode insertRec(int index, int value, ListNode current) {
        // check till index becomes 0
        if (index == 0) {
            // then create a temp node which will consist of the given value.
            // the next of the newly created node will be the previous node's next which is pass given to function call
            ListNode temp = new ListNode(value, current);
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
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    // Questions

    // remove duplicates from sorted LL
    public void removeDup() {
        ListNode temp = head;
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
    private ListNode deleteDuplicates(ListNode head) {
        // check whether the list is empty or not
        if(head == null){
            // return null
            return null;
        }
        // create new temporary node which will point location as head variable.
        ListNode node = head;
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
        ListNode first = firstListHead.head;
        // assign second LL head as second
        ListNode second = secondListHead.head;

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
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // store head of the ans list to return at the end
        ListNode ansHead = new ListNode();
        // now make head and tail same, because empty LL has head and tail at the same point
        ListNode tail = ansHead;
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
    private boolean hasCycle(ListNode head) {
        // take two pointer fast and slow
        // at start they both will point at the head
        ListNode slow = head;
        ListNode fast = head;
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
    private int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
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



    // Start of the LL cycle.
    private ListNode detectCycle(ListNode head) {
        /*
            to solve this question we have to do 3 steps,
                1. find the length of the cycle
                2. move slow ahead by length of cycle times.
                3. move slow and fast one by one, they will meet at the start.
         */

        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // find length of the cycle and break out of the loop
                do{
                    slow = slow.next;
                    length++;
                }while (fast != slow);
                break;
            }
        }
        // if length of the cycle is 0 then return null
        if(length == 0){
            return null;
        }
        // now reassign the fast and slow pointers by head.
        fast = head;
        slow = head;
        // move slow till length of cycle times in the LL.
        while (length > 0) {
            slow = slow.next;
            // decrement the length at each iteration.
            length--;
        }

        // now move fast and slow ahead by one, at some point they will meet, and that will be the starting node of the cycle.
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // now return any node as both are pointing to the same node.
        return slow;
    }


    // happy number problem.
    private boolean isHappy(int n) {
        /*
            To solve this question we have to first understand what is happy number
            A happy number is a number defined by the following process:

                1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
                2.Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which
                 does not include 1.
                3. Those numbers for which this process ends in 1 are happy.


            checkout this link,
            https://leetcode.com/problems/happy-number/solutions/3767573/easy-java-solution-two-pointers-floyd-s-tortoise-and-hare-detailed-explanation/
         */
        int slow = n;
        int fast = n;
        // while loop is not used here because initially slow and
        // fast pointer will be equal only, so the loop won't run.
        do{
            // slow moving one step ahead and fast moving two steps ahead
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        }while (slow != fast);
        // if a cycle exists, then the number is not a happy number
        // then fast and slow will have a value other than 1
        return slow == 1;
    }

    private int findSquareSum(int n) {
        // take sum initially 0
        int sum = 0;
        // run loop till number is greater than 0
        // e.g. 4 / 10 = 0.4
        while (n > 0) {
            // take remainder of number
            int rem = n % 10;
            // add square that of that remainder into previous sum
            sum += rem * rem;
            // now divide that number by 10.
            // e.g. 14/ 10 = 1
            n /= 10;
        }
        // return sum at the end.
        return sum;
    }


    // middle of the list
    private ListNode findMiddle(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        // run this loop until fast reaches to its end or fast != null
        while(fast != null && fast.next != null){
            if (slow == null) {
                slow = head;
            }else
            // move slow ahead by 1
                slow = slow.next;
            // move fast ahead by 2
            fast = fast.next.next;
        }
        // return slow, as when fast is reach to end then slow will at the mid.
        // e.g. if A is running 2 times faster than B, then when A reach to end that time B will be at middle.
        assert slow != null;
        return slow.next;
    }


    // reversing the LL with recursion.
    private void reverseRec(ListNode node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverseRec(tail.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // inplace reverse LL, with iterative method and without tail.
    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
            To solve this question we have to take 3 pointer which will traverse the whole LL.
                pointers will be,
                    prev -> which will be null at the start of the loop
                    present -> present node at which we are, which will be the head.
                    next -> it will be the next node of the present node
         */

        // set the 2 pointer as written in previous comment
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        // run loop till present becomes null
        while (present != null) {
            // update the present node's next node as prev node.
            present.next = prev;
            // move prev ahead by one
            prev = present;
            // move present ahead by one
            present = next;
            // check whether next is null or not, to avoid null pointer exception
            if(next != null)
                next = next.next;
        }
        // when present becomes the null means we reach at the end of the list.
        // then just simply return the prev node. because it will present at the last node. and make that node head.
        return prev;
    }


    // reverse LL-II, reverse LL from given left indexes till right index.
    private ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        /*  e.g.
            1 -> [2 -> 5 -> 6] -> 7
            I have to reverse from 2 till 6.

            What do we require to reverse the box,
                1: the element behind the right index, which is node = 1;
                2: after reversing the box then we have to attach 2 to 7;
                    means we require to store 2 node in some temp node, to connect that node after right
                3: when we will reverse the box then our present element will be at 7, and prev node will be at 6.
                    therefore we have to add that 6 to 1 node's next.
                    but what if their no node present, means what if prev is null.
                    then we have to make head = prev

            Steps to solve this example is,
                1. traverse till left - 1 by skipping every node.
                    after this step we will get the prev node at left - 1,
                    and present node will be at left index location.
                    e.g. prev = 1 ---> we have to store this node in some temp node, because at the end we have to connect this node with last node
                                        of the box, which after reversing going to be first node of the box.
                         present = 2 ---> this node will be our new end of the box.

                         store,
                         newEnd = present
                         left - 1 node = prev
                2. now we will run for loop to reverse the given box, we will run for loop till
                    --> right - left + 1
                        e.g. 4 - 2 + 1 = 3 --> which is the length of the box.
                3. after reversing the box we will get structure like this,
                 ---->>>>       1   [6 -> 5 -> 2]  7
                                here, connections are broken between the box starting and box ending.
                                so we will connect those boxes with their respective next nodes.

                                e.g. here, node having value 1 is store in, last temp node
                                    therefore, last.next = prev
                                                    as after reversing the present pointer will be at 7,
                                                    and prev pointer will be at 6.

                ---->>>>       1 -> [6 -> 5 -> 2]  7
                               here, after connecting the last node with prev node we have to connect end of the box with
                               node after the right index, which is going to be, present node pointer.
                               therefore, newEnd.next = present

         */
        ListNode prevOfPresent = null;
        ListNode present = head;
        ListNode newEnd = null;
        // skip till left - 1
        for (int i = 0; present != null && i < left - 1; i++) {
            prevOfPresent = present;
            present = present.next;
        }

        // save the previous node of box start
        ListNode prevOfBoxStart = prevOfPresent;
        // save the start node of the box, which is going to be end of the box
        newEnd = present;
        assert present != null;
        ListNode next = present.next;

        // reverse between left and right, or reverse the given box
        // length of the box = right - left + 1
        for (int i = 0; present != null && i < (right - left) + 1; i++) {
            present.next = prevOfPresent;
            prevOfPresent = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        // check whether left - 1 node is null or not, means whether left is head or not.
        if(prevOfBoxStart != null){
            prevOfBoxStart.next = prevOfPresent;
        }else{
            // if there is no node behind the box then make previous node of present node head.
            head = prevOfPresent;
        }
        // connect the box end node with next node of the box end.
        newEnd.next = present;
        return head;
    }

    public void palindrome() {
        System.out.println(isPalindrome(head));
    }


    // palindrome link list
    private boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // to find whether the list is palindrome or not first we have find mid of the list then reverse list from that list
        //      and check from start again.

        // find the middle node of the LL.
        ListNode mid = findMiddle(head);
        // reverse the LL from mid. head of that list will be return by reverseLL method.
        ListNode reverseHead = reverseLL(mid);
        // run loop till any of the heads become null
        while (head != null && reverseHead != null) {
            // compare the value of both nodes
            if (head.value != reverseHead.value) {
                // if they mismatch means LL is not palindrome
                return false;
            }
            // move ahead both heads.
            head = head.next;
            reverseHead = reverseHead.next;
        }
        // if loop never loop successfully runs till its end then return true.
        return true;
    }


    // reorder list
    public void reorder() {
        reorderList(head);
    }
    private void reorderList(ListNode head) {
        /*
            Input: head = [1,2,3,4,5]
            Output: [1,5,2,4,3]
         */

        if (head == null || head.next == null) {
            return;
        }
        // get the middle node of the LL
        ListNode mid = findMiddle(head);
        // take pointer for actual head of the LL
        ListNode headFirst = head;
        // take pointer for reverse list of the LL, head of the reverse list will be return by the reverseLL method.
        ListNode headSecond = reverseLL(mid);
        // run till any of the head becomes null
        while (headFirst != null && headSecond != null) {
            // now create a temp pointer which will store the next node of the headFirst node.
            ListNode temp = headFirst.next;
            // modify the headFirst node's next, update it to second head of the List.
            headFirst.next = headSecond;
            // now reassign the temp pointer to headFirst.
            headFirst = temp;
            /*
                why temp pointer because,
                            Input: head = [1,2,3,4,5]
                            Output: [1,5,2,4,3]
                            when 5 is connected to 1 then first head will point to 5.
                            to avoid these we will store 1's next node which is 2 in temp
                            and then reassign that node again to first head.
             */
            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }
    }


    // reverse link list in k part
    private ListNode reverseKGroup(ListNode head, int k) {
        int length = findLength(head);
        if(head == null || head.next == null || k % length == 0 || k <= 1){
            return head;
        }
        /*
            1 -> 2 -> 5 -> End
            1 -> 2 -> 3 -> 4 -> 6 -> End
            c  next
          prev

            c.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = c.next;

         */

        ListNode current = head;
        ListNode prev = null;

        int count = length / k;
        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = current;

            assert current != null;
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }

    private int findLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }


    // Rotate K times.
    private ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        // now get the last node of the list and the length of the LL
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // make the last node's next as head.
        last.next = head;
        int rotations = k & length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = newLast;
        return head;
    }

    private static class ListNode {
        private final int value;
        private ListNode next;

        private ListNode() {
            this.value = 0;
        }
        private ListNode(int value) {
            this.value = value;
        }

        private ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}