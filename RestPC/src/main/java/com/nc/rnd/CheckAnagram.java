package com.nc.rnd;

import java.util.Arrays;

/**
 * Created by nirk0816 on 2/7/2017.
 */
public class CheckAnagram {

    public static void main(String[] args) {

        String str1 = "niravi";
        String str2 = "ravnbi";

        CheckAnagram checkAnagram = new CheckAnagram();
        checkAnagram.check(str1, str2);
    }

    private void check(String str1, String str2)
    {
        if(null == str1 && null == str2)
        {
            System.out.println("Both input strings are null");
        }
        else if(str1.isEmpty() && str2.isEmpty())
        {
            System.out.println("Both input strins are empty");
        }
        else if(str1.length() != str2.length())
        {
            System.out.println("Strings have different lengths, hence Strings are not anagram");
        }
        else
        {
            char [] str1Array = str1.toCharArray();
            char [] str2Array = str2.toCharArray();

            Arrays.sort(str1Array);
            Arrays.sort(str2Array);

            if(Arrays.toString(str1Array).equals(Arrays.toString(str2Array)))
            {
                System.out.println("First String sorted : " + Arrays.toString(str1Array));
                System.out.println("Second String sorted : " + Arrays.toString(str2Array));
                System.out.println("Strings are Anagram");
            }
            else
            {
                System.out.println("First String sorted : " + Arrays.toString(str1Array));
                System.out.println("Second String sorted : " + Arrays.toString(str2Array));
                System.out.println("Strings are not anagram");
            }
        }
    }
}
