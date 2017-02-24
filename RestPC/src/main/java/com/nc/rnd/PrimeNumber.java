package com.nc.rnd;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class PrimeNumber {

    public static void main(String[] args) {

        int inputNumber = 138;

        PrimeNumber primeNumber = new PrimeNumber();
        primeNumber.checkPrime(inputNumber);

    }

    private void checkPrime(int inputNumber)
    {
        boolean prime = true;

        for(int i = 2 ; i < inputNumber ; i++)
        {
            if(inputNumber % i == 0)
            {
                prime = false;
                System.out.println("Input Number " + inputNumber + " is NON Prime");
                break;
            }
        }

        if(prime)
            System.out.println("Input Number " + inputNumber + " is Prime");
    }
}
