package com.OOPS;

import java.util.Arrays;

class Human1 implements Cloneable{
    String name;
    int age;
    int[] arr = new int[5];
    public Human1(int age, String name) {
        this.name = name;
        this.age = age;
        this.arr = new int[]{1, 2, 3, 4,5 ,6 };
    }

    public Human1 (Human1 human) {
        this.name = human.name;
        this.age = human.age;
    }

    // this line of code is just replacement for the code written above.
    // this is the example of the shallow copy clone.
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }

    // deep copy clone
    public Object clone() throws CloneNotSupportedException{
        // first create a clone
        Human1 twin = (Human1) super.clone();

        // now create a new array which will point to the same location of twin.arr but this time it will empty
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
public class Clone {
    public static void main(String[] args) throws CloneNotSupportedException{
        Human1 rohit = new Human1(21, "Rohit Udamale");
        // clone with typical method.
//        Human1 krushna = new Human1(rohit);
//        System.out.println(krushna.name);

        // with cloneable interface.
        Human1 twin = (Human1) rohit.clone();
        System.out.println(twin.age + " " + twin.name);
        System.out.println(Arrays.toString(twin.arr));
        rohit.arr[0] = 100;
        System.out.println(Arrays.toString(rohit.arr) + " rohit arr");
        System.out.println(Arrays.toString(twin.arr) + " twin arr");
    }
}
