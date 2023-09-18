package com.OOPS.CheckAccess;

import com.OOPS.Access;
public class Check extends Access{
    Check(){
        System.out.println(super.a);
    }
    public static void main(String[] args) {
        Access obj = new Access();
        System.out.println(obj.c);
    }
}
