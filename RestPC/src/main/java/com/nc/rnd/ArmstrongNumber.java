package com.nc.rnd;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class ArmstrongNumber {

    public static void main(String args[])
    {

        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        armstrongNumber.findArmstrong(1000);

    }

    private void findArmstrong(int length)
    {
        for(int k=1;k<length;k++)
        {
            int i = k;
            double value = 0;
            for(;;) {
                double num = i % 10;
                value = value + Math.pow(num, 3);
                i = i / 10;
                if(i==0)
                    break;
            }

            if(value == (double)k)
            {
                System.out.println("Armstrong number : " + k);
            }
            else
            {
                //System.out.println("k = "+k+" value = "+value);
            }
        }
    }
}
