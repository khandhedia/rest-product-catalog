package com.nc.rnd;

/**
 * Created by nirk0816 on 2/7/2017.
 */
public class ReplaceCharInString {

    public static void main(String[] args) {

        String replaceChar = "a";
        String newChar = "A";
        String inputStr = "Nirav a a a aaa      Khandhediab";

        ReplaceCharInString replaceCharInString = new ReplaceCharInString();
        System.out.println(replaceCharInString.replaceChar(replaceChar, newChar, inputStr));
    }

    private String replaceChar(String replaceChar, String newChar, String inputStr)
    {
        if(null != inputStr && !inputStr.isEmpty())
        {
            String parts[] = inputStr.split(replaceChar);
            StringBuffer buffer = new StringBuffer();

            for(int i=0 ;i < parts.length ; i++)
            {
                //if(i != parts.length - 1)
                    buffer.append(parts[i]).append(newChar);
                /*else
                    buffer.append(parts[i]);*/
            }

            return buffer.toString().substring(0, inputStr.length());
        }
        else
            return inputStr;

    }
}
