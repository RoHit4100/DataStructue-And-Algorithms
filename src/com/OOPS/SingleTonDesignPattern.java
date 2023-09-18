package com.OOPS;

class Singleton{
    String name;
    // Constructor of the singleton class always should be private
    private Singleton() {
        System.out.println("This is singleton class which have only one object");
    }

    public void setName(String name) {
        this.name = name;
    }
    // to create 1 object of the singleton class we have to create the object using private static and final
    // static because we are going to use in static method.
    // private because we don't want to give direct access to this object to any class.
    // final because it cant modify by any class.
    private static final Singleton object = new Singleton();

    // after creating we have to create a public function which will return the Singleton class object.
    public static Singleton getInstance(){
        return object;
    }
}

public class SingleTonDesignPattern {
    // means only one object is allowed to create.
    public static void main(String[] args) {
        // created one object
        Singleton obj = Singleton.getInstance();
        // created another object
        Singleton obj2 = Singleton.getInstance();
        // both objects are pointing to the same object

        // setting name to rohit by using obj2
        obj2.name = "rohit";
        // printing the same name using the obj.
        System.out.println(obj.name);
    }
}
