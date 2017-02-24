package com.nc.rnd;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class StringReverse {

    public static void main (String args[])
    {
        String inputStr="Nirav       - ---          ----#      Khandhedia";

        StringReverse stringReverse = new StringReverse();
        System.out.println("Reverse of "+inputStr + " is : " + stringReverse.reverse(inputStr));
        System.out.println("Word wise Reverse of "+inputStr + " is : " + stringReverse.wordWiseReverse(inputStr));

    }

    private String wordWiseReverse(String inputStr)
    {
        if(null == inputStr && inputStr.isEmpty())
        {
            return inputStr;
        }

        String wordArray[] = inputStr.split(" ");
        StringBuffer buffer = new StringBuffer();

        for(int i=0 ; i < wordArray.length ; i++)
        {
            buffer.append(" " + reverse(wordArray[i]));
        }

        return buffer.toString();
    }

    private String reverse(String inputStr)
    {
        if(null == inputStr && inputStr.isEmpty())
        {
            return inputStr;
        }
        else
        {
            StringBuffer buffer = new StringBuffer();
            for(int i=inputStr.length() ; i>0;i--)
            {
                buffer.append(inputStr.charAt(i-1));
            }
            return buffer.toString();
        }
    }
}
