package com.LinkedList.Questions;


public class QuestionsLL extends LL{
    // line 101 - remove duplicates
    // line 127 - merge two sorted list.
    // line 209 - LL cycle present or not (fast and slow pointer method).
    // line 231 - length of the LL cycle.
    // line 258 - find the starting point of the LL.
    // line 307 - happy number
    // line 354 - middle of the list.
    // line 371 - reverse LL with recursion
    // line 383 - in-place reversal of LL with iterative method.
    // line 420 - reverse link list between the range.
    // line 515 - check list is palindrome or not.
    // line 547 - reorder list
    // line 586 - reverse LL in k group
    public static void main(String[] args) {

        // merge two sorted list
        LL first = new LL();
        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(5);
        first.display();

        LL second = new LL();
        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(3);
        second.insertLast(4);
        second.insertLast(6);
        second.display();

        second.reorder();
    }
}
