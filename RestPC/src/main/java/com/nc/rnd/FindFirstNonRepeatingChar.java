package com.nc.rnd;

/**
 * Created by nirk0816 on 2/7/2017.
 */
public class FindFirstNonRepeatingChar {

    public static void main(String[] args) {

        String inputStr = "NNiriarav";

        FindFirstNonRepeatingChar findFirstNonRepeatingChar  = new FindFirstNonRepeatingChar();
        findFirstNonRepeatingChar.find(inputStr);

    }

    private void find(String inputStr)
    {
        boolean found = false;

        if(null != inputStr && !inputStr.isEmpty())
        {
            for(int i = 0 ; i<inputStr.length();i++)
            {
                char charUnderWatch = inputStr.charAt(i);

                if(inputStr.indexOf(charUnderWatch, i+1) == -1 && inputStr.substring(0, i).indexOf(charUnderWatch) == -1)
                {
                    System.out.println("First Non Repeating Char is " + inputStr.charAt(i));
                    found = true;
                    break;
                }
            }

            if(!found)
            {
                System.out.println("No Non-Repeating Chars exist in input data");
            }
        }
        else
            System.out.println("Input data is Null or has 0 length");

    }
}
