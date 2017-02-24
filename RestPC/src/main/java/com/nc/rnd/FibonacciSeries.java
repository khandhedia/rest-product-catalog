package com.nc.rnd;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class FibonacciSeries {

    public static void main(String args[]) {

        int first = 1;
        int second = 2;
        int length = 10;

        FibonacciSeries distinctArrayElements = new FibonacciSeries();

        System.out.println("recurrance");
        distinctArrayElements.fibonacciRec(first, second, length);
        System.out.println("\nRegular");
        distinctArrayElements.fibonacci(first, second, length);
        distinctArrayElements.fibonacci(length);
    }

    private void fibonacci(int first, int second, int length) {
        if (length > 0) {
            System.out.println(first);
        }

        if (length > 1) {
            System.out.println(second);
        }

        if (length > 2) {
            for (int i = 0; i < length - 2; i++) {
                int third = first + second;
                System.out.println(third);
                first = second;
                second = third;
            }
        }
    }

    private void fibonacciRec(int first, int second, int length) {
        if (length > 0) {
            System.out.println(first);
        }

        if (length > 1) {
            System.out.println(second);
        }

        if (length > 2) {
            length=length-2;
            fibonacciRecInt(first, second, length);

        }
    }

    private void fibonacciRecInt(int first, int second, int length) {
        int third = first + second;
        System.out.println(third);
        first = second;
        second = third;
        length = length -1 ;
        if(length>0)
            fibonacciRecInt(first, second, length);
    }

    private void fibonacci(int length) {

        int first = 0;
        int second = 1;

        if (length > 0) {
            first = 0;
            System.out.println(first);
        }

        if (length > 1) {
            second = 1;
            System.out.println(second);
        }
        if (length > 2) {
            for (int i = 0; i < length - 2; i++) {
                int third = first + second;
                System.out.println(third);
                first = second;
                second = third;
            }
        }
    }

    private void fibonacciRecursion(int length) {

        int first = 0;
        int second = 1;

        if (length > 0) {
            first = 0;
            System.out.println(first);
        }

        if (length > 1) {
            second = 1;
            System.out.println(second);
        }
        if (length > 2) {
            for (int i = 0; i < length - 2; i++) {
                int third = first + second;
                System.out.println(third);
                first = second;
                second = third;
            }
        }
    }

}
