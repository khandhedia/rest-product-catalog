package com.nc.rnd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by nirk0816 on 2/7/2017.
 */
public class StringPermutations {

    Set<String> perms;

    public static void main(String[] args) {

        String inputStr = "Nirav";

        StringPermutations stringPermutations = new StringPermutations();
        stringPermutations.perms = new HashSet<>();
        stringPermutations.jumble(inputStr);

        Iterator itr = stringPermutations.perms.iterator();
        System.out.println("Printing Permutations");
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }


    }

    private String jumble(String inputStr)
    {
        String lastChar;
        String restStr;

        if (null != inputStr && !inputStr.isEmpty() && inputStr.length() != 1)
        {
            lastChar = inputStr.substring(inputStr.length()-1);
            restStr = inputStr.substring(0, inputStr.length()-1);


            String formed = lastChar + restStr;
            perms.add(formed);

            return jumble(restStr);


        }
        else
            return inputStr;
    }


}
