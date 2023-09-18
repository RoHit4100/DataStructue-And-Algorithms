package com.OOPS;

/*
    To inherit a class, you simply incorporate the definition of one class into another by using the extends keyword.

    class subclass-name extends superclass-name { // body of class
    }

    You can only specify one superclass for any subclass that you create. Java does not support the inheritance of
multiple superclasses into a single subclass. You can, as stated, create a hierarchy of inheritance in which a subclass
becomes a superclass of another subclass. However, no class can be a superclass of itself.

    Although a subclass includes all members of its superclass, it cannot access those members of the superclass
that have been declared as private.

    A Superclass Variable Can Reference a Subclass Object:
    It is important to understand that it is the type of the reference variable—not the type of the object that it refers
to—that determines what members can be accessed.
    When a reference to a subclass object is assigned to a superclass reference variable, you will have access only to
those parts of the object defined by the superclass.


    plainBox      =  weightBox;
    (superclass)     (subclass)

    SUPERCLASS ref = new SUBCLASS();    // HERE ref can only access methods which are available in SUPERCLASS

    Using super:
        Whenever a subclass needs to refer to its immediate superclass, it can do so by use of the keyword super.
    super has two general forms.
    1. The first calls the superclass’ constructor.
    2. The second is used to access a member of the superclass that has been hidden by a member of a subclass.

    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d); // call superclass constructor
        weight = m;
    }

    Here, BoxWeight( ) calls super( ) with the arguments w, h, and d. This causes the Box constructor to be called,
which initializes width, height, and depth using these values. BoxWeight no longer initializes these values itself.
It only needs to initialize the value unique to it: weight. This leaves Box free to make these values private if desired.

    Thus, super( ) always refers to the superclass immediately above the calling class.
    This is true even in a multilevel hierarchy.

    class Box {
        private double width;
        private double height;
        private double depth;

        // construct clone of an object
        Box(Box ob) { // pass object to constructor
            width = ob.width;
            height = ob.height;
            depth = ob.depth;
        }
    }

    class BoxWeight extends Box {
         double weight; // weight of box

         // construct clone of an object
         BoxWeight(BoxWeight ob) { // pass object to constructor
            super(ob);
            weight = ob.weight;
        }
    }

    Notice that super() is passed an object of type BoxWeight—not of type Box.This still invokes the constructor Box(Box ob).

    NOTE: A superclass variable can be used to reference any object derived from that class.
    Thus, we are able to pass a BoxWeight object to the Box constructor.Of course,Box only has knowledge of its own members.

    A Second Use for super
        The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in
        which it is used.

        super.member

    Here, member can be either a method or an instance variable. This second form of super is most applicable to situations
    in which member names of a subclass hide members by the same name in the superclass.

    super( ) always refers to the constructor in the closest superclass. The super( ) in BoxPrice calls the constructor in
BoxWeight. The super( ) in BoxWeight calls the constructor in Box. In a class hierarchy, if a superclass constructor
requires parameters, then all subclasses must pass those parameters “up the line.” This is true whether a
subclass needs parameters of its own.

    If you think about it, it makes sense that constructors complete their execution in order of derivation.
Because a superclass has no knowledge of any subclass, any initialization it needs to perform is separate from and
possibly prerequisite to any initialization performed by the subclass. Therefore, it must complete its execution first.

NOTE: If super( ) is not used in subclass' constructor, then the default or parameterless constructor of each superclass
will be executed.

 */

class Father{
    String surname;
    int fAge;
    int age;
    int property;
    private String secrets;
    int cars;
    Father(){
        System.out.println("This is constructor without any parameter");
    }
    Father(String surname, int property) {
        this.surname = surname;
        this.property = property;
    }
    Father (Son obj) {
        System.out.println("This constructor takes takes object as an argument");
    }
}

// Inheritance
class Son extends Father{
    int sAge;
    int age;
    int sProperty;
    Son(){
        System.out.println("This is the constructor of Son class without any parameter");
    }
    Son(String surname, int fProperty, int sProperty, int age, int sAge) {
        super(surname, fProperty);
        super.fAge = age; // directly giving access to superclass variable
        this.sAge = sAge;
        this.age = age;
        this.sProperty = sProperty;
        System.out.println(super.cars);
    }

    public Son(Son obj) {
        super(obj);
        this.sProperty = obj.sProperty;
    }
}

// Hierarchical inheritance or multilevel inheritance
class GrandSon extends Son{
    GrandSon(String surname, int fProperty, int sProperty, int age, int sAge) {
        super(surname, fProperty, sProperty, age, sAge);
    }
}
public class Inheritance {
    public static void main(String[] args) {
        Son rohit = new Son("rohit", 1000000, 50000000, 48, 21);
        Son krushna = new Son();
//        Son bigBrother = new Son(rohit);
        System.out.println(rohit.property);
        System.out.println(rohit.fAge);
        System.out.println(rohit.age);
//        rohit.secretes
    }
}
