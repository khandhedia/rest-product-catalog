package com.nc.rnd;

/**
 * Created by nirk0816 on 2/7/2017.
 */
public class RemoveCharFromString {

    public static void main(String[] args) {

        String removeChar = "a";
        String inputStr = "Nirav Khandhedia";

        RemoveCharFromString removeCharFromString = new RemoveCharFromString();
        System.out.println(removeCharFromString.removeChar(removeChar, inputStr));
    }

    private String removeChar(String removeChar, String inputStr)
    {
        if(null != inputStr && !inputStr.isEmpty())
        {
            String parts[] = inputStr.split(removeChar);
            StringBuffer buffer = new StringBuffer();

            for(int i=0 ;i < parts.length ; i++)
            {
                buffer.append(parts[i]);
            }

            return buffer.toString();
        }
        else
            return inputStr;

    }
}
