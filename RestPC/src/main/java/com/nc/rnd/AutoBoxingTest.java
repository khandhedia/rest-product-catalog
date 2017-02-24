package com.nc.rnd;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class AutoBoxingTest {


        public static void main(String args[]) {

            // Example 1: == comparison pure primitive – no autoboxing
            int i1 = 1;
            int i2 = 1;
            System.out.println("i1==i2 : " + (i1 == i2)); // true

            // Example 2: equality operator mixing object and primitive
            Integer num1 = 1; // autoboxing
            int num2 = 1;
            System.out.println("num1 == num2 : " + (num1 == num2)); // true

            // Example 3: special case - arises due to autoboxing in Java
            Integer obj1 = 1; // autoboxing will call Integer.valueOf()
            Integer obj2 = 1; // same call to Integer.valueOf() will return same
            // cached Object because it caches objects in the range of -128 to 127
            System.out.println("obj1 == obj2 : " + (obj1 == obj2)); // true

            // Example 3: special case - arises due to autoboxing in Java
            Integer obj11 = 1001; // autoboxing will call Integer.valueOf()
            Integer obj22 = 1001; // same call to Integer.valueOf() will NOT return same
            // cached Object because value is above 128
            System.out.println("obj1 == obj2 : " + (obj11 == obj22)); // false

            // Example 3: special case - arises due to autoboxing in Java
            Integer obj111 = -125; // autoboxing will call Integer.valueOf()
            Integer obj222 = -125; // same call to Integer.valueOf() will NOT return same
            // cached Object because value is above 128
            System.out.println("obj1 == obj2 : " + (obj111 == obj222)); // true

            // Example 4: equality operator - pure object comparison
            Integer one = new Integer(1); // no autoboxing
            Integer anotherOne = new Integer(1);
            System.out.println("one == anotherOne : " + (one == anotherOne)); // false

        }

}
