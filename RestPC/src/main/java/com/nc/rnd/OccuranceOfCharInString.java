package com.nc.rnd;

/**
 * Created by nirk0816 on 2/7/2017.
 */
public class OccuranceOfCharInString {

    public static void main(String[] args) {

        char findChar = 'm';
        String inputStr = "Nirav Khandhedia";

        OccuranceOfCharInString occuranceOfCharInString = new OccuranceOfCharInString();
        occuranceOfCharInString.findOccurance(findChar, inputStr);

    }

    private void findOccurance(char findChar, String inputStr)
    {
        int count = 0;
        if(null != inputStr && !inputStr.isEmpty() && inputStr.indexOf(findChar) != -1)
        {

            char inputStrChars[] = inputStr.toCharArray();
            for(int i=inputStr.indexOf(findChar) ; i < inputStrChars.length ; i++)
            {
                if(inputStrChars[i] == findChar)
                    count++;
            }

            System.out.println("Count = " + count);
        }
        else
        {
            System.out.println("Input Data is Null or has 0 length or doesn't contain character whose occurance is to be counted");
        }
    }
}
