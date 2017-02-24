package com.nc.rnd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class DistinctArrayElements {

    public static void main(String args[]) {
        DistinctArrayElements distinctArrayElements = new DistinctArrayElements();
        int a1[] = {3, 1, 2, 3, 3};
        int a2[] = {3, 4, 5, 6, 2, 7, 4};

        System.out.println(distinctArrayElements.findDistict(a1, a2));
    }

    private int findDistict(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a1.length; i++) {
            if (map.containsKey(a1[i])) {
                Integer value = map.get(map.get(a1[i]));
                value++;
                map.put(a1[i], value);
            } else {
                map.put(a1[i], 1);
            }
        }

        for (int i = 0; i < a2.length; i++) {
            if (map.containsKey(a2[i])) {
                Integer value = map.get(map.get(a2[i]));
                value++;
                map.put(a2[i], value);
            } else {
                map.put(a2[i], 1);
            }
        }

        Set<Integer> keySet = map.keySet();

        int distinctCount = 0;

        Iterator keySetItr = keySet.iterator();
        while(keySetItr.hasNext())
        {
            Integer value = map.get(keySetItr.next());
            if(value == 1)
            {
                distinctCount++;
            }
        }

        return distinctCount;
    }

}
