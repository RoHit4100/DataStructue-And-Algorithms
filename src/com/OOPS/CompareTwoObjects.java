package com.OOPS;

interface GenericInterface<T> {
    void display(T value);
}

class StudentCompare implements Comparable<StudentCompare>{
    float marks;
    int rollNo;
    StudentCompare(int rollNo, float marks){
        this.rollNo = rollNo;
        this.marks = marks;
    }


    @Override
    public int compareTo(StudentCompare b) {
        // if 0 is return means both are equal
        // if 0 < is return means b is bigger else b is smaller
        return (int) (this.marks - b.marks);
    }
}
public class CompareTwoObjects implements GenericInterface<Integer>{
    @Override
    public void display(Integer value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        StudentCompare rohit = new StudentCompare(12, 99);
        StudentCompare krushna = new StudentCompare(13, 98);
        if (rohit.compareTo(krushna) > 0) {
            System.out.println("rohit");
            System.out.println(rohit.compareTo(krushna));
        }
    }
}
