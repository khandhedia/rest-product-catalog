package com.nc.rnd;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class FizzBuzz {

    public static void main(String args[]) {

        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzbuzz(20);

    }

    private void fizzbuzz(int length) {
        for (int i = 1; i <= length; i++) {
            if (i % (3 * 5) == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
