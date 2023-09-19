package com.OOPS;

import java.util.Arrays;

// we are going to make arraylist with the help of generics.
// to add more restrictions on the type we can use syntax like
//      e.g. T ? extends Number
//           where Number is class
class ArrList<T> {
    private static final int INITIAL_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public ArrList(){
        data = new Object[INITIAL_SIZE];
    }

    public void add(T i) {
        if (isFull()) {
            reSize();
        }
        data[size++] = i;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void reSize() {
        Object[] obj = new Object[data.length * 2];
        System.arraycopy(data, 0, obj, 0, data.length);
        data = obj;
    }

    public int size() {
        return size + 1;
    }

    public T remove() {
        @SuppressWarnings("unchecked") T removed = (T)data[--size];
        return removed;
    }
    @Override
    public String toString() {
        return "Elements=" + Arrays.toString(data) + " and size=" + size();
    }
}
public class CustomArrList<E>{

    public static void main(String[] args) {
        ArrList<Integer> list = new ArrList<>();
        for (int i = 1; i < 34; i++) {
            list.add(i * 4);
        }
        System.out.println(list);
        Integer r = list.remove();
        System.out.println(r);
        list.add(2);
        System.out.println(list);
    }
}
